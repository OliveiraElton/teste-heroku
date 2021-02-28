package br.com.gerenciaevento.gerenciaevento.model;

import javax.persistence.*;

@Entity
public class SalaEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private  String name;

    @Column(name = "capacity")
    private int capacity;

    public SalaEvento(){

    }

    public SalaEvento(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
