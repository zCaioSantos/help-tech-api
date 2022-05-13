package br.com.helptechbackend.Controller;

import java.util.List;
import java.util.Optional;

import br.com.helptechbackend.Model.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.helptechbackend.Repository.User_Repository;
import lombok.var;

@RestController
@RequestMapping(path = "/users")
public class User_Controller {
    
    @Autowired
    private User_Repository db;

    @GetMapping(path = "/")
    public List<Users> allUsers() {
        return db.findAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/{id}")
    public Optional<Users> findUserById(@PathVariable int id) {
        return db.findById(id);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/")
    public Users saveUser(@RequestBody Users user) {
        return db.save(user);
    }

    @CrossOrigin(origins = "*")
    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateCliente(@PathVariable int id, @RequestBody Users user) {
        var resp = db.findById(id);

        if (resp.isPresent()) {
            var currentUser = resp.get();
            currentUser.setNome(user.getNome());
            currentUser.setEmail(user.getEmail());
            currentUser.setDepartamento(user.getDepartamento());
            currentUser.setTelefone(user.getTelefone());
            currentUser.setRamal(user.getRamal());
            db.save(currentUser);

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteUsers(@PathVariable int id) {

        var resp = db.findById(id);

        if (resp.isPresent()) {
            db.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();

    }
}
