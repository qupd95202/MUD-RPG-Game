public class test {
    public static void main(String[] arg) {
        Player hero = new Player();
        Weapon weapon = new Weapon();
        weapon.sword();
        hero.getAbility().setName("Hero");
        System.out.println(hero);
        hero.wearArmor(weapon);
        System.out.println(hero);
    }
}
