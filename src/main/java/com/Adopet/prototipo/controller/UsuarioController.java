package com.Adopet.prototipo.controller;

import com.Adopet.prototipo.DTO.DadosListagemUsuario;
import com.Adopet.prototipo.repository.UsuarioRepository;
import com.Adopet.prototipo.usuario.DadosAtualizarUsuario;
import com.Adopet.prototipo.usuario.DadosCadastroUsuario;
import com.Adopet.prototipo.usuario.Usuario;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroUsuario dadosCadastroUsuario){
        repository.save(new Usuario(dadosCadastroUsuario));
    }

    @PutMapping
    @Transactional
    public void atualizarDados(@RequestBody @Valid DadosAtualizarUsuario dadosAtualizarUsuario){
        Usuario usuario = repository.getReferenceById(dadosAtualizarUsuario.id());
        usuario.atualizarInformacoes(dadosAtualizarUsuario);
    }

    @GetMapping
    public List<DadosListagemUsuario> listarTodosUsuarios(){
        return repository.findAll().stream().map(DadosListagemUsuario::new).toList();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> listarById(@PathVariable Long id){
        if(repository.findById(id) == null) {
            throw new RuntimeException("O usuario não pertence a base de dados.");
        }
        return repository.findById(id);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
