package com.company;

import java.util.ArrayList;

public class Pokemon {
    public String name;
    public String type;
    public String size;
    public int HP; // health points
    public int AP; // attack power
    public int DP; // defense
    public ArrayList<Pokemon> yourChoose = new ArrayList<>();
    public ArrayList<Pokemon> enemyChoose = new ArrayList<>();



    public Pokemon(String name,String type,String size,int HP, int AP,int DP){
        this.name=name;
        this.type=type;
        this.size=size;
        this.HP=HP;
        this.AP=AP;
        this.DP=DP;
    }

    public Pokemon() {

    }


    @Override
    public String toString() {
       StringBuilder result=new StringBuilder();
       result.append("name:"+this.name+"; type:"+this.type+"; size:"+this.size+
               "; HP:"+this.HP+"; AP:"+this.AP+"; DP:"+this.DP);
       return result.toString();
    }

}
