package com.viniciushoffmanndev.agroconnect_api.service;

import com.viniciushoffmanndev.agroconnect_api.dto.LoginDTO;
import com.viniciushoffmanndev.agroconnect_api.dto.UsuarioDTO;
import com.viniciushoffmanndev.agroconnect_api.dto.UsuarioResponseDTO;
import com.viniciushoffmanndev.agroconnect_api.model.Usuario;
import com.viniciushoffmanndev.agroconnect_api.model.PerfilEnum;
import com.viniciushoffmanndev.agroconnect_api.repository.UsuarioRepository;
import com.viniciushoffmanndev.agroconnect_api.security.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public UsuarioService(UsuarioRepository usuarioRepository,
                          BCryptPasswordEncoder passwordEncoder,
                          JwtUtil jwtUtil)
    {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public String autenticar(LoginDTO dto) {
        Usuario usuario = usuarioRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Usuário não encontrado"
                ));

        if (!passwordEncoder.matches(dto.getSenha(), usuario.getSenha())) {
            throw new RuntimeException("Senha inválida");
        }

        return jwtUtil.gerarToken(usuario.getEmail());
    }

public UsuarioResponseDTO salvar(UsuarioDTO dto) {
        Usuario usuario = Usuario.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .senha(passwordEncoder.encode(dto.getSenha()))
                .perfil(PerfilEnum.valueOf(dto.getPerfil().toUpperCase())) // cuidado com valores inválidos!
                .cpf(dto.getCpf())
                .telefone(dto.getTelefone())
                .dataNascimento(dto.getDataNascimento())
                .build();

        Usuario salvo = usuarioRepository.save(usuario);

        // Construindo o DTO de saída manualmente
        UsuarioResponseDTO response = new UsuarioResponseDTO();
        response.setId(salvo.getId());
        response.setNome(salvo.getNome());
        response.setEmail(salvo.getEmail());
        response.setPerfil(salvo.getPerfil().name());
        response.setCpf(salvo.getCpf());
        response.setTelefone(salvo.getTelefone());
        response.setDataNascimento(salvo.getDataNascimento());

        return response;

    }

public List<UsuarioResponseDTO> listarTodos() {
    return usuarioRepository.findAll().stream().map(usuario -> {
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setPerfil(usuario.getPerfil().name());
        dto.setCpf(usuario.getCpf());
        dto.setTelefone(usuario.getTelefone());
        dto.setDataNascimento(usuario.getDataNascimento());
        return dto;
    }).toList();
}
}