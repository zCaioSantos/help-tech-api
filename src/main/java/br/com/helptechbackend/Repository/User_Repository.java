package br.com.helptechbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.helptechbackend.Model.Users;

public interface User_Repository extends JpaRepository<Users, Integer> {
    
}
