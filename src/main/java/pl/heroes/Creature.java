package pl.heroes;

class Creature {
    public static final int MAX_HP = 5;
    public static final int DEFENCE = 5;
    public static final int ATTACK = 5;
    public static final String DEAFAULT = "Deafault";
    final CreatureStatistics stats;
    private int currentHp;

    Creature() {
        stats = new CreatureStatistics(DEAFAULT, ATTACK, DEFENCE, MAX_HP);
    }

    Creature(String _name, int _attack, int _defence, int _maxHp) {
        stats = new CreatureStatistics(_name, _attack, _defence, _maxHp);
        currentHp = stats.getMaxHp();
    }

    int calculateDamage() {
        int calculatedDamage = this.stats.getAttack() - this.stats.getDefence();
        if (this.stats.getAttack() - this.stats.getDefence() < 0) {
            return 0;
        } else {
            return calculatedDamage;
        }
    }

    void attack(Creature _defender) {
        _defender.applayDamage(this.calculateDamage());
        if (_defender.isAlive()) {
            this.counterAttack(_defender);
        }
    }

    void counterAttack(Creature _defender) {
        this.applayDamage(_defender.calculateDamage());
    }

    void applayDamage(int _damageToDeal) {
        this.currentHp -= _damageToDeal;
    }

    int getCurrentHp() {
        return currentHp;
    }

    private boolean isAlive() {
        return this.getCurrentHp() > 0;
    }
    
    public String getName() {
        return this.stats.getName();
    }


    public int getAttack() {
        return this.stats.getAttack();
    }


    public int getDefence() {
        return this.stats.getDefence();
    }


    public int getMaxHp() {
        return this.stats.getMaxHp();
    }

}
