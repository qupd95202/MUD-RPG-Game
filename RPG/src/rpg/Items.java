public class Items {

    protected Ability ability = new Ability();
    private int buffTime;

    public int getBuffTime() {
        return buffTime;
    }

    public void setBuffTime(int buffTime) {
        this.buffTime = buffTime;
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
