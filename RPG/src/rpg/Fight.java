package rpg;

import java.util.Random;

public class Fight {
    private Random random = new Random();
    int round = 0;

    public boolean isEscaping(Player player, Monster monster) { //是否逃跑成功
        boolean isEscape = false;
        if (random.nextDouble() <= (player.getAbility().getDex() - monster.getAbility().getDex()) * 0.4) { //(自身敏捷-怪物敏捷)*40%為逃跑率
            isEscape = true;
        }
        return isEscape;
    }

    public void startFight(Player player, Monster monster) throws InterruptedException {  //戰鬥開始
        player.setFighting(true); //處於戰鬥狀態
        player.buffTakeEffect(monster); //buff生效
        if (player.getAbility().getDex() >= monster.getAbility().getDex()) { //判斷誰敏捷高誰先攻擊
            System.out.println(player.getAbility().getName() + "先攻");
            while (!player.isDead() && !monster.isDead()) {//沒有人死的話會一直打下去
                round++;
                System.out.println("\n第" + round + "回合");
                System.out.println(player.getAbility().getName() + "攻擊!");
                attack(player, monster);
                System.out.println(monster.getAbility().getName() + "攻擊!");
                attack(player, monster);
                player.buffCountDown(); //玩家buff扣除一回合
            }
        } else {
            System.out.println(monster.getAbility().getName() + "先攻");
            while (!player.isDead() && !monster.isDead()) {
                round++;
                System.out.println("\n第" + round + "回合");
                System.out.println(monster.getAbility().getName() + "攻擊!");
                attack(player, monster);
                System.out.println(monster.getAbility().getName() + "攻擊!");
                attack(player, monster);
                player.buffCountDown();
            }
        }
        round = 0;//round 歸零
        player.removeBuff(); //buff移除
        player.setFighting(false); //離開戰鬥狀態
        overFight(player, monster); //結算
    }

    public boolean isHit(Character atker, Character defer) {
        return random.nextDouble() >= (defer.getAbility().getDex() - atker.getAbility().getHit()) * 0.2;///判斷如果隨機(0~1)大於(被攻擊方敏捷-攻擊方命中*20%)，就攻擊成功
    }

    public void attack(Character former, Character latter) throws InterruptedException {
        //先手攻擊
        if (isHit(former, latter)) { //判定命中
            Thread.sleep(1500);
            System.out.println("命中了");
            int damage = former.getAbility().getStr() - latter.getAbility().getDef(); //計算傷害
            if (damage > 0) { //判定傷害是否>0
                latter.getAbility().addHp(damage * (-1)); //扣血(+負的血量)
                Thread.sleep(1500);
                System.out.println(former.getAbility().getName() + "對" + latter.getAbility().getName() + "造成了" + damage + "傷害");
                if (latter.isDead()) { //死亡就跳出
                    return;
                }
            } else {
                Thread.sleep(1500);
                System.out.println("被擋下來了，沒有傷害");
            }
        } else {
            Thread.sleep(1500);
            System.out.println("Miss!");
        }
    }

    public void overFight(Player player, Monster monster) throws InterruptedException {
        if (player.isDead()) {
            System.out.println("你死了QQ，請重新來過吧");
        } else {
            int exp = monster.getAbility().getExp();
            Thread.sleep(1500);
            System.out.println("恭喜擊敗 " + monster.getAbility().getName() + " !");
            Thread.sleep(1500);
            player.getAbility().addExp(exp);
            System.out.print("獲得" + exp + "EXP   ");
            player.lvelUp();
            player.getItem(monster.getDropItem());
            System.out.println();
        }
    }
}
