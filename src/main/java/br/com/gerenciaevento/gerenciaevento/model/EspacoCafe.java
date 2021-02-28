package br.com.gerenciaevento.gerenciaevento.model;

import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
@Service
public class EspacoCafe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nameCoffee")
    public  String nameCoffee;

    @Column(name = "capacity")
    private int capacity;

    public EspacoCafe(){

    }

    public EspacoCafe(String nameCoffee, int capacity){
        this.nameCoffee = nameCoffee;
        this.capacity = capacity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameCoffee() {
        return nameCoffee;
    }

    public void setNameCoffee(String nameCoffee) {
        this.nameCoffee = nameCoffee;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}