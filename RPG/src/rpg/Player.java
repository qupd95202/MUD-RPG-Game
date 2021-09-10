import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Random;

public class Player extends Character {

    private ArrayList<Weapon> weaponList = new ArrayList<Weapon>();
    private ArrayList<Armor> armorList = new ArrayList<Armor>();
    private ArrayList<Items> bag = new ArrayList<Items>();
    private ArrayList<Items> buffList = new ArrayList<Items>();
    private int positon;
    private boolean isFighting = false;
    private int whichMap;


    public Player() {
        Ability initialAbility = new Ability();
        initialAbility.setArmorMaxmum(1);
        initialAbility.setItemMaxmum(5);
        initialAbility.setWeaponMaxmum(1);
        initialAbility.setMaxHp(5);
        initialAbility.setHp(5);
        initialAbility.setDef(5);       //初始素質之設定
        initialAbility.setDex(5);
        initialAbility.setStr(5);
        initialAbility.setHit(5);
        initialAbility.setCon(6 * initialAbility.getStr());
        initialAbility.setLV(1);
        initialAbility.setMaxExp(10);
        setAbility(initialAbility);
        positon = 0;  //起始位置在原點

    }

    public void lvelUp() {
        if (getAbility().getExp() >= getAbility().getMaxExp()) {
            getAbility().lvUp();//升等
            getAbility().setExp(getAbility().getExp() - getAbility().getMaxExp());//經驗值歸零+溢出
            getAbility().setMaxExp(getAbility().getMaxExp() * 2);//最大經驗值變成原本兩倍
            getAbility().addStr(2);
            getAbility().addDex(2);
            getAbility().addHp(2);   //各項素質提升
            getAbility().addHit(2);
            getAbility().addDef(2);
            lvelUp(); //判定有無可能一次升多等
        }
    }

    public void goOneStep() {
        positon++; //走一步，自身位置+1
    }

    public void wearWeapon(Weapon weapon) {
        weaponList.add(weapon);     //穿裝備(順便加上能力值)
        getAbility().merge(weapon.ability);
    }

    public void takeOffWeapon(int indexInList) { //脫裝
        if (indexInList <= weaponList.size()) { //不可以選擇超出範圍的裝
            getAbility().unMerge(weaponList.get(indexInList - 1).ability);  // (回歸原本)
            bag.add(weaponList.get(indexInList - 1)); //放回背包
            weaponList.remove(indexInList - 1);// 卸下原本在裝備欄的位置
        } else {
            System.out.println("輸入錯誤");
        }
    }

    public void wearArmor(Armor armor) {
        armorList.add(armor);     //同上
        getAbility().merge(armor.ability);
    }

    public void takeOffArmor(int indexInList) { //脫裝
        if (indexInList <= armorList.size()) { //不可以選擇超出範圍的裝
            getAbility().unMerge(armorList.get(indexInList - 1).ability);  // (回歸原本)
            bag.add(armorList.get(indexInList - 1)); //放回背包
            armorList.remove(indexInList - 1);// 卸下原本在裝備欄的位置
        } else {
            System.out.println("輸入錯誤");
        }
    }

    public void use(int choose) {
        Items item = bag.get(choose - 1);        ////使用背包東西(順便把背包裡的那個刪掉)
        bag.remove(choose - 1);
        this.getAbility().merge(item.ability);
    }

    public void buffCountDown() {
        for(Items items : buffList) {

        }
    }

    public void supply() {
        for (int i = 0; i < bag.size(); i++) {
            System.out.println((i + 1) + ". " + bag.get(0));
        }
    }

    public int getPositon() {
        return positon;
    }

    public void setPositon(int positon) {
        this.positon = positon;
    }

    public int getWhichMap() {
        return whichMap;
    }

    public void setWhichMap(int whichMap) {
        this.whichMap = whichMap;
    }

    public boolean isFighting() {

        return isFighting;
    }

    public void setFighting(boolean fighting) {
        isFighting = fighting;
    }

    public void getItem(Items items) {
        if (bag.size() < getAbility().getItemMaxmum()) {
            bag.add(items);
            System.out.println("獲得" + items.ability.getName());
        } else {
            System.out.println("背包已滿，無法獲得");
        }
    }

    public void printState() {
        System.out.println("\n" + this);
    }

    public void printEquipment() {
        System.out.println("裝備數量上限: 武器:" + getAbility().getWeaponMaxmum() + " 防具:" + getAbility().getArmorMaxmum());
        System.out.println("當前裝備:");
        System.out.print("武器:");
        for (Weapon weapon : weaponList) {
            System.out.print(" " + weapon.ability.getName());
        }
        System.out.println("\n防具:");
        for (Armor armor : armorList) {
            System.out.print(" " + armor.ability.getName());
        }
        System.out.println("背包空間:" + getAbility().getItemMaxmum() + "  負重(當前/最大): " + getAbility().getEquipmentWeight() + "/" + getAbility().getCon() + "\n");
    }

    public void printAll() {
        printState();
        printEquipment();
    }

    @Override
    public String toString() {
        return "名字: " + getAbility().getName() + "\n" + "等級: " + getAbility().getLV() + "   " +
                "經驗值(當前/最大):" + getAbility().getExp() + "/" + getAbility().getMaxExp() + "\n" +
                getAbility();
    }
}
