public class Character {
    private String name;
    private int maxHp;
    private int hp;
    private int str;
    private int def;
    private int hit;
    private int dex;
    private int exp;
    private int LV;
    private String kind;

    public Character() {
        exp = 0;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }


    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setLV(int LV) {
        this.LV = LV;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getName() {

        return name;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getHp() {
        return hp;
    }

    public int getStr() {
        return str;
    }

    public int getDef() {
        return def;
    }

    public int getHit() {
        return hit;
    }

    public int getDex() {
        return dex;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }


    public int getExp() {
        return exp;
    }

    public int getLV() {
        return LV;
    }

    public String getKind() {
        return kind;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
        hp = maxHp;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void addHp(int value) {
        hp += value;
    }

    public void addStr(int value) {
        str += value;
    }

    public void addDef(int value) {
        def += value;
    }

    public void addDex(int value) {
        dex += value;
    }

    public void addHit(int value) {
        hit += value;
    }
}
