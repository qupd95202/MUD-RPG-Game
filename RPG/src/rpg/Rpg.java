/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author mickytsai
 */
public class Rpg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //角色命名
        Player newPlayer = new Player();
        System.out.println("歡迎進入遊戲");
        System.out.print("請輸入角色名稱->");
        newPlayer.getAbility().setName(sc.next());
        System.out.println("你好" + newPlayer.getAbility().getName());
        
        Weapon s = new Weapon();
        s.axe();
        newPlayer.wearWeapon(s);
        System.out.println(newPlayer);
    }    
}        
//        //選擇起始武器（調用初始武器的ArrayList)
//        System.out.println("請選擇一個武器");
//        for(int i = 0; i < weaponList.size(); i++){
//            System.out.println("名稱：" + weaponList.get(i).getName() + 
//                        "攻擊：" + weaponList.get(i).getAttack() + 
//                        "重量：" + weaponList.get(i).getWeight() 
//            );
//        }
//        int chooseW = sc.nextInt();
//        newPlayer.setStr(newPlayer.getStr() + weaponList.get(chooseW).getAttack()) ;
//        
//        
//        //選擇起始防具 （調用初始防具的ArrayList)
//        System.out.println("請選擇一個防具");
//        for(int i = 0; i < List.size(); i++){
//            System.out.println("名稱：" + armorList.get(i).getName() + 
//                        "攻擊：" + armorList.get(i).getAttack() + 
//                        "重量：" + armorList.get(i).getWeight()
//            );
//        }
//        test
//
//
//        //進入隨機地圖
//        
//        
//        //進入事件
//        
//        
//        
//        //死亡或殺死一個王
//        
//        
//        //過關
    

