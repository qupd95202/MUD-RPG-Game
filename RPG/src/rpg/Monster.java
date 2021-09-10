import java.util.ArrayList;

public class Monster extends Character {
    protected final ArrayList<Item> itemList = new ArrayList<Item>();  // 掉落物清單
    protected final Item item = new Item();  // 用來new出新掉落物

    public Item getDropItem() {
        return null;
    }
}