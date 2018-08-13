package models;

import javax.persistence.*;

@Entity
@Table(name="cars")

public class Car {

    private int id;
    private String name;
    private int doors;

    public Car(){
    }

    public Car(String name, int doors) {
        this.name = name;
        this.doors = doors;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column (name="doors")
    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }
}
