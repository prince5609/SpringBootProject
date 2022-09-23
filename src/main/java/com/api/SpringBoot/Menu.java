package com.api.SpringBoot;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity

public class Menu implements Serializable {
    @Id
    int sno;
    String name;
    int cost;

    public Menu(int sno, String name, int cost){
        super();
        this.sno= sno;
        this.name = name;
        this.cost = cost;
    }

    public Menu(){
        super();
    }

    public int getSno(){
        return sno;
    }

    public void setSno(int sno){
        this.sno = sno;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getCost(){
        return cost;
    }

    public void setCost(int cost){
        this.cost = cost;
    }

    @Override
    public String toString(){
        return "[ " + sno + " " + name + " " + cost + " ]";
    }
}
