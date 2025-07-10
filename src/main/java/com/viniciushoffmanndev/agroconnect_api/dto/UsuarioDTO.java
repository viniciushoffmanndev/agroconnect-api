package com.viniciushoffmanndev.agroconnect_api.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Past;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UsuarioDTO {

    private String nome;

    @jakarta.validation.constraints.Email(message = "E-mail inválido")
    private String email;

    private String senha;

    private String perfil; // Será validado ou convertido no service para PerfilEnum

    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF deve estar no formato 000.000.000-00")
    private String cpf;

    @Pattern(regexp = "\\(\\d{2}\\)\\s\\d{4,5}-\\d{4}", message = "Telefone deve estar no formato (XX) XXXXX-XXXX")
    private String telefone;

    @Past(message = "Data de nascimento deve ser no passado")
    private LocalDate dataNascimento;

    // Getters e Setters
}