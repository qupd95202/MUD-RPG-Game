/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import java.util.Scanner;

/**
 *
 * @author mickytsai
 */
public class RPG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //角色命名
        Player newPlayer = new Player();
        System.out.println("歡迎進入遊戲");
        System.out.print("請輸入角色名稱->");
        newPlayer.setName(sc.next());
        System.out.println("你好" + newPlayer.getName());
        //選擇起始武器
        System.out.println("請選擇一個武器");
        //進入隨機地圖
        
        
        //進入事件
        
        
        
        //死亡或殺死一個王
        
        
        //過關
    }
    public void showList (){    
        
    }
    
    
}
