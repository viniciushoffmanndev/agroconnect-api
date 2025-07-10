package com.viniciushoffmanndev.agroconnect_api.service;

import com.viniciushoffmanndev.agroconnect_api.dto.UsuarioDTO;
import com.viniciushoffmanndev.agroconnect_api.dto.UsuarioResponseDTO;
import com.viniciushoffmanndev.agroconnect_api.model.Usuario;
import com.viniciushoffmanndev.agroconnect_api.model.PerfilEnum;
import com.viniciushoffmanndev.agroconnect_api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioResponseDTO salvar(UsuarioDTO dto) {
        Usuario usuario = Usuario.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .senha(dto.getSenha())
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
}