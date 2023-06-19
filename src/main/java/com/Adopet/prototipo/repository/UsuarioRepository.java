package com.Adopet.prototipo.repository;

import com.Adopet.prototipo.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
