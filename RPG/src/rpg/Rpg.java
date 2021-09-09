import java.util.Scanner;
import java.util.ArrayList;
/**
 *

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
        System.out.println(newPlayer);


        //選擇起始武器（調用初始武器的ArrayList)
        System.out.println("請選擇一個武器");
        Weapon w = new Weapon();
        ArrayList<Items> weaponList = new ArrayList<Items>();

        w.axe();
        System.out.print("選擇1 ");
        w.printItem();
        weaponList.add(w);

        w.bow();
        System.out.print("選擇2 ");
        w.printItem();
        weaponList.add(w);

        w.wand();
        System.out.print("選擇3 ");
        w.printItem();
        weaponList.add(w);

        System.out.print("選擇->");
        int choose = sc.nextInt();
        newPlayer.wearWeapon(weaponList.get(choose-1));
        System.out.println(newPlayer);


//        for(int i = 0; i < weaponList.size(); i++){
//            System.out.println(weaponList);
//        }






//        ArrayList<Weapon> armorList = new ArrayList<Item>();

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
//
//
//
        //進入隨機地圖


        //進入事件



        //死亡或殺死一個王


        //過關
    }
}
