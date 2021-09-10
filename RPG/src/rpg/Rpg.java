package rpg;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author mickytsai
 */
public class Rpg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Fight fight = new Fight();
        Monster monster = new Monster();


        //角色命名
        Player newPlayer = new Player();
        Player player = new Player();
        System.out.println("歡迎進入遊戲");
        System.out.print("請輸入角色名稱->");
        newPlayer.getAbility().setName(sc.next());
        System.out.println("你好 " + newPlayer.getAbility().getName());
        System.out.println();
//        System.out.println(newPlayer);


        //選擇起始武器（調用初始武器的ArrayList)
        System.out.println("請選擇一個武器");
        ArrayList<Weapon> weaponList = new ArrayList<Weapon>();

        Weapon w1 = new Weapon();
        w1.sword();
        System.out.print("選擇1 ");
        w1.printItem();
        weaponList.add(w1);

        Weapon w2 = new Weapon();
        w2.axe();
        System.out.print("選擇2 ");
        w2.printItem();
        weaponList.add(w2);

        Weapon w3 = new Weapon();
        w3.wand();
        System.out.print("選擇3 ");
        w3.printItem();
        weaponList.add(w3);

        System.out.print("選擇->");
        int chooseW = sc.nextInt();
        newPlayer.wearWeapon(weaponList.get(chooseW - 1));
        System.out.println();
//        newPlayer.printAll();
//        System.out.println();


        //選擇起始防具（調用初始防具的ArrayList)
        System.out.println("請選擇一個防具");
        ArrayList<Armor> armorList = new ArrayList<Armor>();

        Armor a1 = new Armor();
        a1.woodenArmor();
        System.out.print("選擇1 ");
        a1.printItem();
        armorList.add(a1);

        Armor a2 = new Armor();
        a2.chainMail();
        System.out.print("選擇2 ");
        a2.printItem();
        armorList.add(a2);

        Armor a3 = new Armor();
        a3.plateArmor();
        System.out.print("選擇3 ");
        a3.printItem();
        armorList.add(a3);

        System.out.print("選擇->");
        int chooseA = sc.nextInt();
        newPlayer.wearArmor(armorList.get(chooseA - 1));
        System.out.println();
//        newPlayer.printAll();
//        System.out.println();


        player = newPlayer;//將角色選完武器的狀態先暫存
        int kindCount = 0; //過關的地圖數
        while (true) {
            //地圖選擇（隨機）
            int kind = Random(1, 2);
//            kind = 1;// 測試用

            switch (kind) {
                case 1:
                    System.out.println("進入地圖：森林");
                    break;
                case 2:
                    System.out.println("進入地圖：深淵");
                    break;
            }

            //地圖：森林
            while (kind == 1 && kindCount < 2) {

                while (true) {
                    System.out.println("選擇行動");
                    System.out.println("1.繼續冒險");
                    System.out.println("2.顯示角色狀態 + 顯示裝備");
                    System.out.println("3.打開背包");
                    int choose = sc.nextInt();
                    switch (choose) {
                        case 1:
                            System.out.println("深入森林冒險");
                            break;
                        case 2:
                            newPlayer.printAll();
                            break;
                        case 3:
                            if (newPlayer.getBag().size() == 0) {
                                System.out.println("背包裡面空空如也");
                                break;
                            }
                            newPlayer.supply();
                            System.out.println("背包說明：");
                            System.out.println("1~" + newPlayer.getBag().size() +
                                    " status = 顯示道具功能 1~" +
                                    newPlayer.getBag().size());
                            System.out.println("1~" + newPlayer.getBag().size() +
                                    " use = 使用道具1~" +
                                    newPlayer.getBag().size());
                            System.out.println("輸入exit離開");


                            System.out.println("請選擇道具 不使用就輸入0");
                            int selectInt = sc.nextInt();
                            System.out.println("顯示道具功能請輸入:status\n"
                                    + "使用道具請輸入:use\n"
                                    + "輸入exit離開");
                            String selectStr = sc.next();

                            if (selectStr.equals("use")) {
                                boolean bo = newPlayer.use(selectInt);
                                if (bo) {
                                    System.out.println("成功使用");
                                }
                                if (bo) {
                                    System.out.println("此道具無法使用");
                                }
                            } else if (selectStr.equals("status")) {
                                newPlayer.getBag().get(selectInt - 1).printItem();
                            } else if (selectStr.equals("exit")) {
                                break;
                            }
                    }
                    if (choose == 1) {
                        break;
                    }
                }


                //Boss戰
                if (newPlayer.getPositon() == 5) {
                    System.out.println("遇到Boss !");
                    Animal boss = new Animal();
                    boss.elephant();
                    System.out.println("Boss是" + boss.ability.getName() + "!");
                    fight.startFight(newPlayer, boss);

                    if (newPlayer.isDead()) {
                        newPlayer.setPositon(0);//步數重算
                        newPlayer = player; //角色回到選完武器的初始
                        break;
                    }
                    kindCount++; //沒死＝勝利
                    kind = 2; //切換到另一張地圖
                    newPlayer.setPositon(0);//步數重算
                    if (kindCount == 1) {
                        System.out.println("你將前往深淵!!!");
                    }
                    break;
                }


                //事件
                int event = Random(0, 5);
//                event = sc.nextInt();// 測試用

                switch (event) {
                    case 0://沒事發生
                        System.out.println("沒事發生，繼續走 ");
                        newPlayer.goOneStep();
                        System.out.println("你已經走了 " + newPlayer.getPositon() + " 步");
                        System.out.println();
                        break;


                    case 1://遇到被動怪物 要先抓出怪物
//                        Animal animal = new Animal();
//                        animal = monster.getAnimals().get(Random(0, 3));//隨機挑怪物
                        Animal animal = monster.genAnimal();//隨機挑怪物
                        System.out.println("遇到" + animal.ability.getName() + "要逃跑嗎？ ");
                        System.out.println("選擇1：逃跑\n" + "選擇2：戰鬥\n" + "選擇3：使用道具 ");
                        int choose = sc.nextInt();
                        switch (choose) {
                            case 1:
                                System.out.println("你選擇逃跑");
                                if (fight.isEscaping(newPlayer, animal)) {
                                    System.out.println("逃跑成功");
                                } else {
                                    System.out.println("逃跑失敗 開始戰鬥");
                                    fight.startFight(newPlayer, animal);
                                }
                                break;
                            case 2:
                                System.out.println("你選擇戰鬥");
                                fight.startFight(newPlayer, animal);
                                break;
                            case 3:
                                newPlayer.supply();
                                System.out.println("請選擇道具 不使用就輸入0");
                                int selectInt = sc.nextInt();
                                System.out.println("顯示道具功能請輸入:status\n"
                                        + "使用道具請輸入:use\n"
                                        + "輸入exit離開\n");
                                String selectStr = sc.next();

                                if (selectStr.equals("use")) {
                                    boolean bo = newPlayer.use(selectInt);
                                    if (bo) {
                                        System.out.println("成功使用");
                                    }
                                    if (bo) {
                                        System.out.println("此道具無法使用");
                                    }
                                } else if (selectStr.equals("status")) {
                                    newPlayer.getBag().get(selectInt - 1).printItem();
                                } else if (selectStr.equals("exit")) {
                                    System.out.println("背包關上");
                                }
                                System.out.println("還想用道具!? 認命戰鬥吧");
                                fight.startFight(newPlayer, animal);
                                break;

                        }
                        if (newPlayer.isDead()) {
                            newPlayer.setPositon(0);//步數重算
                            newPlayer = player; //角色回到選完武器的初始
                            break;
                        }
                        newPlayer.goOneStep();
                        System.out.println("你已經走了 " + newPlayer.getPositon() + " 步");
                        System.out.println();
                        break;


                    case 2://遇到主動怪物

//                        animal = monster.getAnimals().get(Random(0, 3));//隨機挑怪物
                        Animal animal2 = monster.genAnimal();//隨機挑怪物
                        System.out.println("遇到主動怪物" + animal2.ability.getName() + "不能逃跑！");
                        System.out.println("戰鬥開始");
                        fight.startFight(newPlayer, animal2);

                        if (newPlayer.isDead()) {
                            newPlayer.setPositon(0);//步數重算
                            newPlayer = player; //角色回到選完武器的初始
                            break;
                        }
                        newPlayer.goOneStep();
                        System.out.println("你已經走了 " + newPlayer.getPositon() + " 步");
                        System.out.println();
                        break;


                    case 3: //遇到岔路
                        System.out.println("遇到岔路 ");
                        newPlayer.goOneStep();
                        System.out.println("你已經走了 " + newPlayer.getPositon() + " 步");
                        System.out.println();
                        break;

                    case 4://遇到寶箱
                        ArrayList<Item> treasureList1 = new ArrayList<Item>();
                        Item healingPotion = new Item();
                        healingPotion.healingPotion();
                        treasureList1.add(healingPotion);

                        Item powerIncreasePotion = new Item();
                        powerIncreasePotion.powerIncreasePotion();
                        treasureList1.add(powerIncreasePotion);

                        Weapon bow = new Weapon();
                        bow.bow();
                        treasureList1.add(bow);

                        newPlayer.getItem(treasureList1.get(Random(0, 3)));

                        newPlayer.goOneStep();
                        System.out.println("你已經走了 " + newPlayer.getPositon() + " 步");
                        System.out.println();
                        break;
                }
            }


            //地圖：深淵
            while (kind == 2 && kindCount < 2) {
                while (true) {
                    System.out.println("選擇行動");
                    System.out.println("1.繼續冒險");
                    System.out.println("2.顯示角色狀態 + 顯示裝備");
                    System.out.println("3.打開背包");
                    int choose = sc.nextInt();
                    switch (choose) {
                        case 1:
                            System.out.println("深入深淵冒險");
                            break;
                        case 2:
                            newPlayer.printAll();
                            break;
                        case 3:
                            if (newPlayer.getBag().size() == 0) {
                                System.out.println("背包裡面空空如也");
                                break;
                            }
                            newPlayer.supply();
                            System.out.println("背包說明：");
                            System.out.println("1~" + newPlayer.getBag().size() +
                                    " status = 顯示道具功能 1~" +
                                    newPlayer.getBag().size());
                            System.out.println("1~" + newPlayer.getBag().size() +
                                    " use = 使用道具1~" +
                                    newPlayer.getBag().size());
                            System.out.println("輸入exit離開");


                            System.out.println("請選擇道具 不使用就輸入0");
                            int selectInt = sc.nextInt();
                            System.out.println("顯示道具功能請輸入:status\n"
                                    + "使用道具請輸入:use\n"
                                    + "輸入exit離開\n");
                            String selectStr = sc.next();

                            if (selectStr.equals("use")) {
                                boolean bo = newPlayer.use(selectInt);
                                if (bo) {
                                    System.out.println("使用成功");
                                }
                                if (bo) {
                                    System.out.println("此道具無法使用");
                                }
                            } else if (selectStr.equals("status")) {
                                newPlayer.getBag().get(selectInt - 1).printItem();
                            } else if (selectStr.equals("exit")) {
                                break;
                            }
                    }
                    if (choose == 1) {
                        break;
                    }
                }

                //Boss戰
                if (newPlayer.getPositon() == 5) {
                    System.out.println("遇到Boss !");
                    Demon boss = new Demon();
                    boss.bahamut();
                    System.out.println("Boss是" + boss.ability.getName() + "!");
                    fight.startFight(newPlayer, boss);

                    if (newPlayer.isDead()) {
                        newPlayer.setPositon(0);//步數重算
                        newPlayer = player; //角色回到選完武器的初始
                        break;
                    }
                    kindCount++; //沒死＝勝利
                    kind = 1; //切換到另一張地圖
                    newPlayer.setPositon(0);//步數重算
                    if (kindCount == 1) {
                        System.out.println("你將前往森林!!!");
                    }
                    break;
                }

                //事件
                int event = Random(0, 5);
//                event = sc.nextInt();// 測試用
                switch (event) {
                    case 0://沒事發生
                        System.out.println("沒事發生，繼續走 ");
                        newPlayer.goOneStep();
                        System.out.println("你已經走了 " + newPlayer.getPositon() + " 步");
                        System.out.println();
                        break;


                    case 1://遇到被動怪物 要先抓出怪物
//                        Animal animal = new Animal();
//                        animal = monster.getAnimals().get(Random(0, 3));//隨機挑怪物
                        Demon demon = monster.genDemon();//隨機挑怪物
                        System.out.println("遇到" + demon.ability.getName() + "要逃跑嗎？ ");
                        System.out.println("選擇1：逃跑\n" + "選擇2：戰鬥\n" + "選擇3：使用道具 ");
                        int choose = sc.nextInt();
                        switch (choose) {
                            case 1:
                                System.out.println("你選擇逃跑");
                                if (fight.isEscaping(newPlayer, demon)) {
                                    System.out.println("逃跑成功");
                                } else {
                                    System.out.println("逃跑失敗 開始戰鬥");
                                    fight.startFight(newPlayer, demon);
                                }
                                break;
                            case 2:
                                System.out.println("你選擇戰鬥");
                                fight.startFight(newPlayer, demon);
                                break;
                            case 3:
                                newPlayer.supply();
                                System.out.println("請選擇道具 不使用就輸入0");
                                int selectInt = sc.nextInt();
                                System.out.println("顯示道具功能請輸入:status\n"
                                        + "使用道具請輸入:use\n"
                                        + "輸入exit離開\n");
                                String selectStr = sc.next();

                                if (selectStr.equals("use")) {
                                    boolean bo = newPlayer.use(selectInt);
                                    if (bo) {
                                        System.out.println("成功使用");
                                    }
                                    if (bo) {
                                        System.out.println("此道具無法使用");
                                    }
                                } else if (selectStr.equals("status")) {
                                    newPlayer.getBag().get(selectInt - 1).printItem();
                                } else if (selectStr.equals("exit")) {
                                    System.out.println("背包關上");
                                }
                                System.out.println("還想用道具!? 認命戰鬥吧");
                                fight.startFight(newPlayer, demon);
                                break;
                        }
                        if (newPlayer.isDead()) {
                            newPlayer.setPositon(0);//步數重算
                            newPlayer = player; //角色回到選完武器的初始
                            break;
                        }
                        newPlayer.goOneStep();
                        System.out.println("你已經走了 " + newPlayer.getPositon() + " 步");
                        System.out.println();
                        break;


                    case 2://遇到主動怪物

//                        animal = monster.getAnimals().get(Random(0, 3));//隨機挑怪物
                        Demon demon2 = monster.genDemon();//隨機挑怪物
                        System.out.println("遇到主動怪物" + demon2.ability.getName() + "不能逃跑！");
                        System.out.println("戰鬥開始");
                        fight.startFight(newPlayer, demon2);

                        if (newPlayer.isDead()) {
                            newPlayer.setPositon(0);//步數重算
                            newPlayer = player; //角色回到選完武器的初始
                            break;
                        }
                        newPlayer.goOneStep();
                        System.out.println("你已經走了 " + newPlayer.getPositon() + " 步");
                        System.out.println();

                        break;

                    case 3: //遇到岔路
                        System.out.println("遇到岔路 ");
                        newPlayer.goOneStep();
                        System.out.println("你已經走了 " + newPlayer.getPositon() + " 步");
                        System.out.println();

                        break;

                    case 4://遇到寶箱
                        ArrayList<Item> treasureList2 = new ArrayList<Item>();
                        Item healingPotion = new Item();
                        healingPotion.healingPotion();
                        treasureList2.add(healingPotion);

                        Armor leatherArmor = new Armor();
                        leatherArmor.leatherArmor();
                        treasureList2.add(leatherArmor);

                        Item defenseIncreasePotion = new Item();
                        defenseIncreasePotion.defenceIncreasePotion();
                        treasureList2.add(defenseIncreasePotion);

                        newPlayer.getItem(treasureList2.get(Random(0, 3)));

                        newPlayer.goOneStep();
                        System.out.println("你已經走了 " + newPlayer.getPositon() + " 步");
                        System.out.println();

                        break;
                }
            }

            if (kindCount == 2) {
                break;
            }
        }
        System.out.println("!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("恭喜通關!!!你是真正的勇者");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!");
    }

    public static int Random(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}