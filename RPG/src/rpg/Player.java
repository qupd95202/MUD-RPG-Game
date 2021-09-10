import java.util.ArrayList;

public class Player extends Character {

    private ArrayList<Weapon> weaponList = new ArrayList<Weapon>();
    private ArrayList<Armor> armorList = new ArrayList<Armor>();
    private ArrayList<Item> bag = new ArrayList<Item>();
    private ArrayList<Item> buffList = new ArrayList<Item>();
    private int positon;
    private boolean isFighting = false;


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
            System.out.println("恭喜升等  目前等級: Lv." + getAbility().getLV());
            getAbility().setExp(getAbility().getExp() - getAbility().getMaxExp());//經驗值歸零+溢出
            getAbility().setMaxExp(getAbility().getMaxExp() * 2);//最大經驗值變成原本兩倍
            getAbility().addStr(2);
            getAbility().addDex(2);
            getAbility().addHp(2);   //各項素質提升
            getAbility().addHit(2);
            getAbility().addDef(2);
            System.out.println("所有素質提升");
            printState();
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

    public boolean use(int choose) {////使用背包東西(順便把背包裡的那個刪掉) + 回傳布林值判斷使用成功與否
        Item item = bag.get(choose - 1);     //背包裡的那個東西
        boolean isOk = false;
        if (item.isPermanentBuff()) { //先判斷是否為永久型buff型道具
            buffList.add(item);
            bag.remove(choose - 1);
            isOk = true;
        } else if (item.getBuffTime() > 0 && isFighting) { //判斷是否為戰鬥中使用的buff道具
            buffList.add(item);
            bag.remove(choose - 1);
            isOk = true;
        } else if (item.getUseable()) {   //其他種道具使用
            getAbility().merge(item.ability);
            bag.remove(item);
            isOk = true;
        }
        return isOk;
    }

    public void buffTakeEffect(Character monster) {  //判斷buff生效
        for (Item item : buffList) {
            if (item.isPermanentBuff()) {
                if (item.getAgainstAnimalOrDemon() == monster.getKind()) {  //判斷對何種怪物生效
                    getAbility().merge(item.ability);
                }
            } else {
                getAbility().merge(item.ability);
            }
        }
    }

    public void buffCountDown() {  //buff倒數 (不管永久性buff)
        for (Item items : buffList) {
            if (!items.isPermanentBuff()) {
                items.reduceBuffTime();
            }
            if (items.getBuffTime() == 0) {
                getAbility().unMerge(items.ability); //復原狀態
                buffList.remove(items); //至buff列表移除
            }
        }
    }

    public void removeBuff() {
        for (Item item : buffList) {
            if (!item.isPermanentBuff()) {
                getAbility().unMerge(item.ability);  //復原狀態
                buffList.remove(item); //至buff列表移除
            } else {
                getAbility().unMerge(item.ability); //永久性buff只會復原狀態不移除
            }
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

    public boolean isFighting() {
        return isFighting;
    }

    public void setFighting(boolean fighting) {
        isFighting = fighting;
    }

    public void getItem(Item item) {
        if (bag.size() < getAbility().getItemMaxmum()) {
            bag.add(item);
            System.out.println("獲得" + item.ability.getName());
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
