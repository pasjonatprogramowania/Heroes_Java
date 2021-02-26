package pl.heroes;

class Creature {
    private final CreatureStatistics stats;

    public Creature(String _name, int _attack, int _defence, int _maxHp) {
        stats = new CreatureStatistics(_name, _attack, _defence, _maxHp);
    }


}
