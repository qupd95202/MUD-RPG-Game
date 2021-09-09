import java.util.ArrayList;

public class Player extends Character {

    private ArrayList<Drops> weaponList = new ArrayList<Drops>();
    private ArrayList<Drops> equipmentList = new ArrayList<Drops>();
    private ArrayList<Drops> itemList = new ArrayList<Drops>();

    public Player() {
        Ability initialAbility = new Ability();
        initialAbility.setArmorMaxmum(1);
        initialAbility.setItemMaxmum(5);
        initialAbility.setWeaponMaxmum(1);
        initialAbility.setMaxHp(5);
        initialAbility.setHp(5);
        initialAbility.setDef(5);
        initialAbility.setDex(5);
        initialAbility.setStr(5);
        initialAbility.setHit(5);
        this.addDex(5);
        this.setStr(5);           //初始素質之設定
        this.setHit(5);
        this.setDef(5);
        con = this.getStr() * 6;
        this.setLV(1);
        this.setExp(0);
        maxExp = 10;
        position = 0;  //一開始位在原點
        equipmentWeight + {
        }

        public void lvelUp () {
            if (getExp() >= getMaxExp()) {
                setLV(getLV() + 1);//升等
                setExp(getExp() - getMaxExp());//經驗值歸零+溢出
                setMaxExp(getMaxExp() * 2);//最大經驗值變成原本兩倍
                addStr(2);
                addDex(2);
                addHp(2);   //各項素質提升
                addHit(2);
                addDef(2);
                lvelUp(); //判定有無可能一次升多等
            }
        }

        public void go () {
            setPosition(getPosition() + 1); //走一步，自身位置+1
        }

        @Override
        public String toString () {
            return "姓名: " + getName() + "\n" + "等級: " + getLV() +
                    "經驗值(當前/最大):" + getExp() + "/" + getMaxExp() +
                    "各項素質:\n" +
                    "血量(當前/最大): " + getHp() + "/" + getMaxHp() + "\n" +
                    "力量: " + getStr() + "\n" +
                    "敏捷: " + getDex() + "\n" +
                    "命中: " + getHit() + "\n" +
                    "防禦: " + getDef() + "\n" +
                    "裝備數量上限: 武器:" + getWeaponMaxmum() + " 防具:" + getEquipmentMaxmum() +
                    "背包空間:" + getItemMaxmum() + "負重(當前/最大): "
        }
    }
}