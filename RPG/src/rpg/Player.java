public class Player extends Character {
    private int itemMaxmum;
    private int weaponMaxmum;
    private int equipmentMaxmum;
    private int con;
    private int maxExp;

    public int getItemMaxmum() {
        return itemMaxmum;
    }

    public void setItemMaxmum(int itemMaxmum) {
        this.itemMaxmum = itemMaxmum;
    }

    public int getWeaponMaxmum() {
        return weaponMaxmum;
    }

    public void setWeaponMaxmum(int weaponMaxmum) {
        this.weaponMaxmum = weaponMaxmum;
    }

    public int getEquipmentMaxmum() {
        return equipmentMaxmum;
    }

    public void setEquipmentMaxmum(int equipmentMaxmum) {
        this.equipmentMaxmum = equipmentMaxmum;
    }

    public int getCon() {
        return con;
    }

    public void setCon(int con) {
        this.con = con;
    }

    public int getMaxExp() {
        return maxExp;
    }

    public void setMaxExp(int maxExp) {
        this.maxExp = maxExp;
    }

    public Player() {
        itemMaxmum = 5;
        weaponMaxmum = 1;
        equipmentMaxmum = 1;
        this.setMaxHp(5);
        this.addDex(5);
        this.setStr(5);
        this.setHit(5);
        this.setDef(5);
        con = this.getStr() * 6;
        this.setLV(1);

        this.setExp(0);
        maxExp = 10;
    }

    public void lvelUp() {
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
}
