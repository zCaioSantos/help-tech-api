package br.com.helptechbackend.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "tb_products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Protucts {
    
    @Id
    @Column(name = "products_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "nmr_serie")
    private String nmr_serie;

    @Column(name = "processador")
    private String processador;

    @Column(name = "memoria_ram")
    private String memoria_ram;

    @Column(name = "hd")
    private String hd;

    @Column(name = "ssd")
    private String ssd;

    @Column(name = "sistema_operacional")
    private String sistema_operacional;

    @Column(name = "nmr_anydesk")
    private int nmr_anydesk;

    @Column(name = "users_id")
    private int usuario;

}
