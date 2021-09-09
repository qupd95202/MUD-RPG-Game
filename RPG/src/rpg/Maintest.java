/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPG;

import java.util.Scanner;

/**
 *
 * @author wewe23370030
 */
public class Maintest {

    public static void main(String[] args) {
        Item item = new Item();
        
    }

    public void useItem(int select) {
        switch (select) {
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            case 5:
                
                break;   
                
        }
    }

    public static int input(String str) {
        System.out.println(str);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    
    public void initialWeaponArr(){
        Weapon[] weapon = new Weapon[3];
        weapon[0].sword();
        weapon[1].axe();
        weapon[2].wand();
    }
    
    public void initialDefenseArr(){
        Defense a = new Defense();
        Defense[] defense = new Defense[3];
        defense[0].woodenArmor();
        defense[1].chainMail();
        defense[2].plateArmor();
    }
}
