package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table (name = "heroes")


public class Hero implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    public String name;
    @Column(name = "universe")
    private String universe;
    @Column(name = "power")
    private int power;
    @Column(name = "description")
    private String description;
    @Column(name = "alive")
    private boolean alive;

    public Hero(){
    }


    public Hero(String name, String universe, int power, String description, boolean alive){
        //this.id = id;
        this.name = name;
        this.universe = universe;
        this.power = power;
        this.description = description;
        this.alive = alive;
    }


    public String getName(){
        return name;
    }

    public String getUniverse(){
        return universe;
    }

    public int getId(){
        return id;
    }

    public int getPower(){
        return power;
    }

    public String getDescription(){
        return description;
    }

    public boolean getAlive(){
        return alive;
    }






    /*public void setId(int id){
        this.id = id;
    }
    */
    //public void setId(int id){this.id = id;}

    public void setName(String name){
        this.name = name;
    }

    public void setUniverse(String universe){
        this.universe = universe;
    }

    public void setPower(int power){
        this.power = power;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setAlive(boolean alive){
        this.alive = alive;
    }

}
