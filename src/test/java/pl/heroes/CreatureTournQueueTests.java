package pl.heroes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreatureTournQueueTests {

    public static final int MAX_HP = 5;
    public static final int DEFENCE = 5;
    public static final int ATTACK = 5;
    public static final String DEAFAULT = "Deafault";

    @Test
    void shouldReturnActiveCreature() {
        ArrayList<Creature> arrayList = new ArrayList<>();
        Creature creature = new Creature(DEAFAULT, ATTACK, DEFENCE, MAX_HP);

        arrayList.add(creature);
        CreatureTournQueue queue = new CreatureTournQueue(arrayList);

        assertEquals(creature, queue.getActiveCreature());
    }

    @Test
    void shouldChangeActiveCreature() {
        ArrayList<Creature> arrayList = new ArrayList<>();
        Creature creature = new Creature(DEAFAULT, ATTACK, DEFENCE, MAX_HP);
        Creature creature2 = new Creature(DEAFAULT, ATTACK, DEFENCE, MAX_HP);
        Creature creature3 = new Creature(DEAFAULT, ATTACK, DEFENCE, MAX_HP);

        arrayList.add(creature);
        arrayList.add(creature2);
        arrayList.add(creature3);
        CreatureTournQueue queue = new CreatureTournQueue(arrayList);
        assertEquals(creature, queue.getActiveCreature());
        queue.next();
        assertEquals(creature2, queue.getActiveCreature());
        queue.next();
        assertEquals(creature3, queue.getActiveCreature());
        queue.next();
        assertEquals(creature, queue.getActiveCreature());
    }

}
