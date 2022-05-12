package br.com.helptechbackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.helptechbackend.Model.Login;
import br.com.helptechbackend.Repository.Login_Repository;

@RestController
@RequestMapping(path = "/logins")
public class Login_Controller {
    
    @Autowired
    private Login_Repository db;

    @PostMapping(path = "/")
    public boolean login(@RequestBody Login login) {
        Login user = db.logar(login.getNome(), login.getSenha());
        if (user != null) {
            return true;
        }
        return false;
    }
}
