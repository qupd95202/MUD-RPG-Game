import java.util.ArrayList;

public class Demon extends Monster {

    public Demon() {
        setKind(2);  // 初始化設定動物在地圖2(深淵)
        item.heartOfGhost();  // 初始化設定掉落物為動物皮
        itemList.add(item);  // 將動物皮加入掉落物清單
    }

    public void demonWolf() {
        ability.setName("魔狼");
        ability.setHp(2);
        ability.setStr(7);
        ability.setDef(2);
        ability.setHit(5);
        ability.setDex(4);
        ability.setExp(5);
        ability.setLV(1);
        setAbility(ability);
        if (isDead()) {
            item.wolfTooth();
            itemList.add(item);
        }
    }  // 設定魔狼的基本屬性&死後掉落物

    public void celestialHuang() {
        ability.setName("黃大仙");
        ability.setHp(4);
        ability.setStr(6);
        ability.setDef(3);
        ability.setHit(5);
        ability.setDex(5);
        ability.setExp(5);
        ability.setLV(1);
        setAbility(ability);
        if (isDead()) {
            item.leather();
            itemList.add(item);
        }
    }  // 設定黃大仙的基本屬性&死後掉落物

    public void mountainDemon() {
        ability.setName("魑");
        ability.setHp(3);
        ability.setStr(6);
        ability.setDef(3);
        ability.setHit(4);
        ability.setDex(4);
        ability.setExp(5);
        ability.setLV(1);
        setAbility(ability);
        if (isDead()) {
            item.glass();
            itemList.add(item);
        }
    }  // 設定魑的基本屬性&死後掉落物

    public void bahamut() {
        ability.setName("巴哈姆特");
        ability.setHp(7);
        ability.setStr(8);
        ability.setDef(4);
        ability.setHit(7);
        ability.setDex(5);
        ability.setExp(10);
        ability.setLV(2);
        setAbility(ability);
        if (isDead()) {
            item.demomSlayerMark();
            itemList.add(item);
        }
    }  // 設定巴哈姆特的基本屬性&死後掉落物

    public Item getDropItem() {
        return null;
    }
}