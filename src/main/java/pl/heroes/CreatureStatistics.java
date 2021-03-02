package pl.heroes;

class CreatureStatistics {

    final private String name;
    final private int attack;
    final private int defence;
    final private int maxHp;

    CreatureStatistics(String _name, int _attack, int _defence, int _maxHp) {
        name = _name;
        attack = _attack;
        defence = _defence;
        maxHp = _maxHp;
    }

    String getName() {
        return name;
    }


    int getAttack() {
        return attack;
    }


    int getDefence() {
        return defence;
    }


    int getMaxHp() {
        return maxHp;
    }

}
