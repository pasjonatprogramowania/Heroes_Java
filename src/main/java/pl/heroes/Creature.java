package pl.heroes;

class Creature {
    private static final int MAX_HP = 5;
    private static final int DEFENCE = 5;
    private static final int ATTACK = 5;
    private static final String DEAFAULT = "Deafault";
    final CreatureStatistics stats;
    private int currentHp;
    private boolean wasCounterAttack = false;

    Creature() {
        stats = new CreatureStatistics(DEAFAULT, ATTACK, DEFENCE, MAX_HP);
    }

    Creature(String _name, int _attack, int _defence, int _maxHp) {
        stats = new CreatureStatistics(_name, _attack, _defence, _maxHp);
        currentHp = stats.getMaxHp();
    }

    private int calculateDamage(Creature _defender) {
        int calculatedDamage = this.getAttack() - _defender.getDefence();
        if (calculatedDamage < 0) return 0;
        else return calculatedDamage;
    }

    void attack(Creature _defender) {
        if (this.isAlive()) {
            int calcDamage = this.calculateDamage(_defender);
            _defender.applyDamage(calcDamage);
            if (_defender.isAlive() && !_defender.wasCounterAttack) {
                this.counterAttack(_defender);
            }
        }
    }

    void counterAttack(Creature _defender) {
        int calcDamage = _defender.calculateDamage(this);
        this.applyDamage(calcDamage);
        _defender.changeCounterAttackFlag();
    }

    void changeCounterAttackFlag() {
        this.wasCounterAttack = !this.wasCounterAttack;
    }

    private boolean isAlive() {
        return this.getCurrentHp() > 0;
    }

    void applyDamage(int _damageToDeal) {
        this.currentHp -= _damageToDeal;
    }

    int getCurrentHp() {
        return currentHp;
    }

    String getName() {
        return this.stats.getName();
    }

    int getAttack() {
        return this.stats.getAttack();
    }

    int getDefence() {
        return this.stats.getDefence();
    }

    int getMaxHp() {
        return this.stats.getMaxHp();
    }

}
