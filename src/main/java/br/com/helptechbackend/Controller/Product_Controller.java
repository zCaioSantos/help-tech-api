package br.com.helptechbackend.Controller;

import java.util.List;
import java.util.Optional;

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

import br.com.helptechbackend.Model.Protucts;
import br.com.helptechbackend.Repository.Product_Repository;
import lombok.var;

@RestController
@RequestMapping(path = "/products")
public class Product_Controller {

    @Autowired
    private Product_Repository db;

    @GetMapping(path = "/")
    public List<Protucts> allProtucts() {
        return db.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/{id}")
    public Optional<Protucts> findProtuctsById(@PathVariable int id) {
        return db.findById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/")
    public Protucts saveProtucts(@RequestBody Protucts protucts) {
        return db.save(protucts);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateProtucts(@PathVariable int id, @RequestBody Protucts protucts) {
        var resp = db.findById(id);

        if (resp.isPresent()) {
            var currentUser = resp.get();
            currentUser.setMarca(protucts.getMarca());
            currentUser.setHd(protucts.getHd());
            currentUser.setMemoria_ram(protucts.getMemoria_ram());
            currentUser.setModelo(protucts.getModelo());
            currentUser.setProcessador(protucts.getProcessador());
            currentUser.setSsd(protucts.getSsd());
            currentUser.setNmr_serie(protucts.getNmr_serie());
            currentUser.setUsuario(protucts.getUsuario());
            currentUser.setNmr_anydesk(protucts.getNmr_anydesk());
            currentUser.setSistema_operacional(protucts.getSistema_operacional());
            db.save(currentUser);

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteProtucts(@PathVariable int id) {

        var resp = db.findById(id);

        if (resp.isPresent()) {
            db.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();

    }
}
