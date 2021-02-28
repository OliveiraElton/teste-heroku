package br.com.gerenciaevento.gerenciaevento.model;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "espacoCafe")
    private String espacoCafe;

    @Column(name = "salaEvento")
    private String salaEvento;

    public Pessoa(){

    }

    public Pessoa(String name, String lastname, String email, String espacoCafe, String salaEvento){
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.espacoCafe = espacoCafe;
        this.salaEvento = salaEvento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEspacoCafe() {
        return espacoCafe;
    }

    public void setEspacoCafe(String espacoCafe) {
        this.espacoCafe = espacoCafe;
    }

    public String getSalaEvento() {
        return salaEvento;
    }

    public void setSalaEvento(String salaEvento) {
        this.salaEvento = salaEvento;
    }
}
