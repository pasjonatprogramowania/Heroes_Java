package pl.heroes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class BoardTests {

    public static final int MAX_HP = 5;
    public static final int DEFENCE = 5;
    public static final int ATTACK = 5;
    public static final String DEAFAULT = "Deafault";

    @Test
    void shouldNotAddCreatureToTileNotOnBoard() {
        Board board = new Board();
        Point point = new Point(100000, 1000);
        Creature creature = new Creature(DEAFAULT, ATTACK, DEFENCE, MAX_HP);
        assertThrows(IllegalArgumentException.class, () -> board.add(point, creature));
    }

    @Test
    void shouldNotAddCreatureToTileWhereIsCreature() {
        Board board = new Board();
        Point point = new Point(1, 1);
        Point point2 = new Point(1, 1);
        Creature creature = new Creature(DEAFAULT, ATTACK, DEFENCE, MAX_HP);
        Creature creature2 = new Creature(DEAFAULT, ATTACK, DEFENCE, MAX_HP);
        board.add(point, creature);
        board.add(point2, creature2);
        assertThrows(IllegalArgumentException.class, () -> board.add(point, creature));
    }

    @Test
    void shouldAddNewCreatureToBoard() {
        Board board = new Board();
        Point point = new Point(1, 1);
        Creature creature = new Creature(DEAFAULT, ATTACK, DEFENCE, MAX_HP);

        board.add(point, creature);
        Creature creatureFromBoard = board.get(point.getX(), point.getY());
        assertEquals(creature, creatureFromBoard);

    }
}
