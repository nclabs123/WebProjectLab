package models;


public class Hero {
    public int id;
    public String name;
    public String universe;
    public int power;
    public String description;
    public boolean alive;

    public Hero(){
    }


    public Hero(int id, String name, String universe, int power, String description, boolean alive){
        this.id = id;
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

    public int getID(){
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




    public void setId(int id){
        this.id = id;
    }

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
