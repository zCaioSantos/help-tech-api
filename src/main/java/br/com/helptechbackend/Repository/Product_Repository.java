package br.com.helptechbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.helptechbackend.Model.Protucts;

public interface Product_Repository extends JpaRepository<Protucts, Integer> {
    
}
