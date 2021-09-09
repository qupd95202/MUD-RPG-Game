import java.util.ArrayList;

public class Player extends Character {

    private ArrayList<Items> weaponList = new ArrayList<Items>();
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

    public void use(int choose) {
        this.getAbility().merge(ItemssList.get(choose - 1).ability);
    }

    public void changeWhenWearingEquipment() {
        for (Items weapon : weaponList) {
            getAbility().merge(weapon.ability);
        }                                     //穿武器防具時帶來的變化
        for (Items armor : armorList) {
            getAbility().merge(armor.ability);
        }
    }

    public void supply() {
        for (int i = 0; i < ItemssList.size(); i++) {
            System.out.println((i + 1) + ". " + ItemssList.get(0));
        }
    }

    @Override
    public String toString() {
        return "名字: " + getAbility().getName() + "\n" + "等級: " + getAbility().getLV() + "   " +
                "經驗值(當前/最大):" + getAbility().getExp() + "/" + getAbility().getMaxExp() + "\n" +
                getAbility() +
                "裝備數量上限: 武器:" + getAbility().getWeaponMaxmum() + " 防具:" + getAbility().getArmorMaxmum() + "\n" +
                "背包空間:" + getAbility().getItemMaxmum() + "  負重(當前/最大): " + getAbility().getEquipmentWeight() + "/" + getAbility().getCon();
    }
}
