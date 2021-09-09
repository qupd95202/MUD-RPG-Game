/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

/**
 *
 * @author wewe23370030
 */
public class Defense extends Item {

    private int defense;
    private int weight;
    private boolean initial;

    public Defense() {
    }

    public void woodenArmor() {
        this.setDefense(1);
        this.setWeight(10);
        this.setInitial(true);
        this.setName("木甲");
    }

    public void chainMail() {
        this.setDefense(2);
        this.setWeight(15);
        this.setInitial(true);
        this.setName("鎖子甲");
    }

    public void plateArmor() {
        this.setDefense(4);
        this.setWeight(20);
        this.setInitial(true);
        this.setName("板甲");
    }

    public void leatherArmor() {
        this.setDefense(2);
        this.setWeight(9);
        this.setInitial(false);
        this.setName("皮甲");
    }

    public void setDefense(int attack) {
        this.defense = attack;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setInitial(boolean initial) {
        this.initial = initial;
    }

    public int getDefense() {
        return this.defense;
    }

    public int getWeight() {
        return this.weight;
    }

    public boolean getInitial() {
        return this.initial;
    }
}
