import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;

public class Player extends Character {

    private ArrayList<Weapon> weaponList = new ArrayList<Weapon>();
    private ArrayList<Items> armorList = new ArrayList<Items>();
    private ArrayList<Items> ItemssList = new ArrayList<Items>();
    private int positon;

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

    public void wearArmor(Items armor) {
        armorList.add(armor);     //同上
        getAbility().merge(armor.ability);
    }

    public void use(int choose) {
        this.getAbility().merge(ItemssList.get(choose - 1).ability);
    }

    public void supply() {
        for (int i = 0; i < ItemssList.size(); i++) {
            System.out.println((i + 1) + ". " + ItemssList.get(0));
        }
    }

    public void printStatte() {
        System.out.println(this);
    }

    public void printEquipment() {
        System.out.println("裝備數量上限: 武器:" + getAbility().getWeaponMaxmum() + " 防具:" + getAbility().getArmorMaxmum());
        System.out.println("當前裝備:");
        System.out.print("武器:");
        for(Weapon weapon : weaponList){
            System.out.print(" " + weapon.ability.getName());
        }
        System.out.println("\n防具:");
        for(Items armor : armorList){
            System.out.print(" " + armor.ability.getName());
        }
        System.out.println("背包空間:" + getAbility().getItemMaxmum() + "  負重(當前/最大): " + getAbility().getEquipmentWeight() + "/" + getAbility().getCon());
    }

    public void printAll() {

    }

    @Override
    public String toString() {
        return "名字: " + getAbility().getName() + "\n" + "等級: " + getAbility().getLV() + "   " +
                "經驗值(當前/最大):" + getAbility().getExp() + "/" + getAbility().getMaxExp() + "\n" +
                getAbility();
    }
}
