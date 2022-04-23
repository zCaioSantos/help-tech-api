package br.com.helptechbackend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.helptechbackend.Model.Login;
import br.com.helptechbackend.Repository.Login_Repository;

@RestController
@RequestMapping(path = "/logins")
public class Login_Controller {
    
    @Autowired
    private Login_Repository db;

    @GetMapping(path = "/")
    public List<Login> allLogins() {
        return db.findAll();
    }
}
