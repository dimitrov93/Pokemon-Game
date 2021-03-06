
package com.company;

public class Pokemon {
    private String name;
    private String type;
    private String size;
    private int healthPoints;
    private int attackPower;
    private int defensePoints;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getHealthPoints(){
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints){
        this.healthPoints=healthPoints;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower){
        this.attackPower=attackPower;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    public void setDefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }

    public Pokemon(String name, String type, String size, int healthPoints, int attackPower, int defensePoints) {
        setName(name);
        setType(type);
        setSize(size);
        setHealthPoints(healthPoints);
        setAttackPower(attackPower);
        setDefensePoints(defensePoints);
    }

    public Pokemon() {

    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("name:" + getName() + "; type:" + getType() + "; size:" + getSize() +
                "; healthPoints:" +getHealthPoints() + "; attackPower:" + getAttackPower() +
                "; defense:" + getDefensePoints());
        return result.toString();
    }
}