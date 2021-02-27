package pl.heroes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BoardTests {

    public static final int MAX_HP = 5;
    public static final int DEFENCE = 5;
    public static final int ATTACK = 5;
    public static final String DEAFAULT = "Deafault";

    @Test
    void shouldReturnNullForEmptyFiled() {
        Board board = new Board();
        assertNull(board.get(1, 1));
    }

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

        assertThrows(IllegalArgumentException.class, () -> board.add(point2, creature2));
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

    @Test
    void shouldMoveCreatureToNewEmptyField() {
        Board board = new Board();
        Point point = new Point(1, 1);
        Creature creature = new Creature(DEAFAULT, ATTACK, DEFENCE, MAX_HP);

        board.add(point, creature);
        board.move(point, new Point(2, 2));
        Creature creatureFromBoard = board.get(2, 2);

        assertEquals(creature, creatureFromBoard);
    }

    @Test
    void shouldNotMoveCreatureOnTileWithAnotherCreature() {
        Board board = new Board();
        Point point = new Point(1, 1);
        Point point2 = new Point(2, 2);
        Creature creature = new Creature(DEAFAULT, ATTACK, DEFENCE, MAX_HP);
        Creature creature2 = new Creature(DEAFAULT, ATTACK, DEFENCE, MAX_HP);

        board.add(point, creature);
        board.add(point2, creature2);

        assertThrows(IllegalArgumentException.class, () -> board.move(point, new Point(2, 2)));
    }
}
