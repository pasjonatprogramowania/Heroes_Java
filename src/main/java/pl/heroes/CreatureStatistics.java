package pl.heroes;

public class CreatureStatistics {


    final private String name;
    final private int attack;
    final private int defence;
    final private int maxHp;


    public CreatureStatistics(String _name, int _attack, int _defence, int _maxHp) {
        name = _name;
        attack = _attack;
        defence = _defence;
        maxHp = _maxHp;
    }

    public String getName() {
        return name;
    }


    public int getAttack() {
        return attack;
    }


    public int getDefence() {
        return defence;
    }


    public int getMaxHp() {
        return maxHp;
    }

}
