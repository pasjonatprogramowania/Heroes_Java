package pl.heroes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

public class AttackTests {

    @Test
    void attackerShouldDealDamage() {
        Creature attacker = new Creature("att", 5, 1, 100);
        Creature defender = new Creature("def", 1, 1, 100);

        int defHp = defender.getCurrentHp();
        attacker.attack(defender);

        assertNotSame(defHp, defender.getCurrentHp());
    }

    @Test
    void defenderShouldNotSelfHealAndNotTakeDamage() {
        Creature attacker = new Creature("att", 1, 1, 100);
        Creature defender = new Creature("def", 1, 10000, 100);

        attacker.attack(defender);
        int defHp = defender.getCurrentHp();

        assertEquals(defHp, defender.stats.getMaxHp());
    }

    @Test
    void defenderShouldNotTakeDamage() {
        Creature attacker = new Creature("att", 1, 1, 100);
        Creature defender = new Creature("def", 1, 1, 100);

        int defHp = defender.getCurrentHp();
        attacker.attack(defender);

        assertEquals(defHp, defender.getCurrentHp());
    }
}
