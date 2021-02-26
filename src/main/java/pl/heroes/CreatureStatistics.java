package pl.heroes;

public class CreatureStatistics {

    String name;
    int attack;
    int defence;
    int maxHp;


    public CreatureStatistics(String _name, int _attack, int _defence, int _maxHp) {
        name = _name;
        attack = _attack;
        defence = _defence;
        maxHp = _maxHp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

}
