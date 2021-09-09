/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPG;

/**
 *
 * @author wewe23370030
 */
public class Item {

    private String name;
    private boolean useable;
    private int price;
    private String use;
    
    public Item() {
    }

    
    public void setUse(String use){
        this.use = use;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setUseable(boolean initial) {
        this.useable = initial;
    }

    public boolean getUseable() {
        return this.useable;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    public void healingPotion() {
        setName("治療藥水");
        setUseable(true);
        setPrice(3);
    }

    public void powerIncreasePotion() {
        setName("力量增強藥水");
        setUseable(true);
        setPrice(2);
    }

    public void defenceIncreasePotion() {
        setName("防禦增強藥水");
        setUseable(true);
        setPrice(2);
    }
    
    public void leather(){
        setName("動物皮");
        setUseable(false);
        setPrice(1);
    }
    
    public void wolfLeg(){
        setName("狼腿");
        setUseable(false);
        setPrice(1);
    }
    
    public void lionClaw(){
        setName("獅爪");
        setUseable(false);
        setPrice(1);
    }
    
    public void printItem(){
        System.out.print("名稱:" + this.name + "\t價格:" + this.price);
        if(useable){
            System.out.println("\t用途:" + use);
        }
    }
}
