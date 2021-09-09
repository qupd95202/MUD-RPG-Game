public class Character {
    private Ability ability;
    private String kind;

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public boolean isDead() {
        Boolean isDead = false;
        if (ability.getHp() <= 0) {
            isDead = true;
        }
        return true;
    }
}
