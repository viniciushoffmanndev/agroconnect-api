package com.viniciushoffmanndev.agroconnect_api.controller;


import com.viniciushoffmanndev.agroconnect_api.dto.UsuarioDTO;
import com.viniciushoffmanndev.agroconnect_api.dto.UsuarioResponseDTO;
import com.viniciushoffmanndev.agroconnect_api.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> cadastrar(@RequestBody @Valid UsuarioDTO dto) {
        UsuarioResponseDTO response = usuarioService.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
