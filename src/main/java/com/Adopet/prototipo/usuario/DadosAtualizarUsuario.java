package com.Adopet.prototipo.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizarUsuario(
        Long id,
        String nome,
        String email,
        String telefone,
        String senha) {
}
