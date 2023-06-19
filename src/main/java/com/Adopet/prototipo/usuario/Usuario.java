package com.Adopet.prototipo.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String senha;

    public Usuario(DadosCadastroUsuario dadosCadastroUsuario){
        this.nome = dadosCadastroUsuario.nome();
        this.email = dadosCadastroUsuario.email();
        this.senha = dadosCadastroUsuario.senha();
        this.telefone = dadosCadastroUsuario.telefone();
    }

    public void atualizarInformacoes(DadosAtualizarUsuario dadosAtualizarUsuario) {
        if(dadosAtualizarUsuario.nome() != null){
            this.nome = dadosAtualizarUsuario.nome();
        }
        if(dadosAtualizarUsuario.email() != null){
            this.email = dadosAtualizarUsuario.email();
        }
        if(dadosAtualizarUsuario.telefone() != null){
            this.telefone = dadosAtualizarUsuario.telefone();
        }
        if(dadosAtualizarUsuario.senha() != null){
            this.senha = dadosAtualizarUsuario.senha();

        }
    }
}
