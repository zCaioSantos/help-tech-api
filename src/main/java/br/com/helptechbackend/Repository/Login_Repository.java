package br.com.helptechbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.helptechbackend.Model.Login;

public interface Login_Repository extends JpaRepository<Login, Integer> {
    
}
