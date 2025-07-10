package com.viniciushoffmanndev.agroconnect_api.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class UsuarioResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private String perfil;
    private String cpf;
    private String telefone;
    private LocalDate dataNascimento;
}