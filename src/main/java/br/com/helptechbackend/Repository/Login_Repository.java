package br.com.helptechbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.helptechbackend.Model.Login;

public interface Login_Repository extends JpaRepository<Login, Integer> {
    
    @Query(nativeQuery = true, value = "select * from tb_login where usuario = :usuarioParam and senha = :senhaParam")
    Login logar(String usuarioParam, String senhaParam);

}
