package pl.heroes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CounterAttack {

    @Test
    void counterAttackShouldDealDamage() {
        Creature attacker = new Creature("att", 1, 1, 100);
        Creature defender = new Creature("def", 5, 1, 100);

        attacker.attack(defender);

        assertEquals(attacker.getCurrentHp(), 96);
    }

    @Test
    void defenderShouldBeKilledInAttackAndNotDealCounterAttack() {
        Creature attacker = new Creature("att", 50, 50, 100);
        Creature defender = new Creature("def", 1, 1, 1);

        attacker.attack(defender);

        assertTrue(defender.getCurrentHp() <= 0);
    }

    @Test
    void creatureShouldCounterAttackOnlyOnceAtTour() {
        Creature attacker = new Creature("Attacker", 5, 0, 100);
        Creature defender = new Creature("Defender", 5, 0, 100);
        Creature attacker2 = new Creature("Attcker2", 5, 0, 100);

        attacker.attack(defender);
        attacker2.attack(defender);

        assertSame(attacker2.getCurrentHp(), attacker2.getMaxHp());
    }
}
