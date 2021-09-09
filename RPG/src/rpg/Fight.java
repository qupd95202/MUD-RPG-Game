import java.util.Random;

public class Fight {
    private Random random = new Random();

    public void isEscaping(Character player, Character monster) { //要改不林
        boolean isEscape = false;
        if (random.nextDouble() <= (player.getAbility().getDex() - monster.getAbility().getDex()) * 0.4) { //(自身敏捷-怪物敏捷)*40%為逃跑率
            isEscape = true;
        }
    }

    public void startFight(Character player, Character monster) {
        if (player.getAbility().getDex() >= monster.getAbility().getDex()) {
            while (!player.isDead() && !monster.isDead()) {
                attack(player, monster);
            }
        } else {
            while (!player.isDead() && !monster.isDead()) {
                attack(monster, player);
            }
        }
    }

    public boolean isHit(Character atker, Character defer) {
        return random.nextDouble() >= (defer.getAbility().getDex() - atker.getAbility().getHit()) * 0.2;///判斷如果隨機(0~1)大於(被攻擊方敏捷-攻擊方命中*20%)，就攻擊成功
    }

    public void attack(Character former, Character latter) {
        //先手攻擊
        if (isHit(former, latter)) { //判定命中
            int damage = former.getAbility().getStr() - latter.getAbility().getDef(); //計算傷害
            if (damage > 0) { //判定傷害是否>0
                latter.getAbility().addHp(damage * (-1));   //扣血(+負的血量)
                if (latter.isDead()) { //死亡就跳出
                    return;
                }
            }
        }
        //後手攻擊
        if (isHit(latter, former)) {
            int damage = latter.getAbility().getStr() - former.getAbility().getDef();
            if (damage > 0) {
                former.getAbility().addHp(damage * -1);
                if (former.isDead()) {
                    return;
                }
            }
        }
    }

}
