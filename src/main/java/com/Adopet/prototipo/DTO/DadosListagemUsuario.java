package com.Adopet.prototipo.DTO;

import com.Adopet.prototipo.usuario.Usuario;

import java.awt.*;

public record DadosListagemUsuario(String nome, String email) {
    public DadosListagemUsuario(Usuario usuario){
        this(usuario.getNome(), usuario.getEmail());
    }
}
