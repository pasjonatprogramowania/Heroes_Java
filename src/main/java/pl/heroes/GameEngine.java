package pl.heroes;

import java.util.List;

public class GameEngine {

    private final Board board;
    private final CreatureTournQueue queue;
    private List<Creature> creatureArray;

    GameEngine(List<Creature> _creatures1, List<Creature> _creatures2) {
        board = new Board();
        putCreaturesToBoard(_creatures1, _creatures2);
        creatureArray.addAll(_creatures1);
        creatureArray.addAll(_creatures2);
        queue = new CreatureTournQueue(creatureArray);
    }

    private void putCreaturesToBoard(List<Creature> _creatures1, List<Creature> _creatures2) {
        putCreaturesToOneSideOnABoard(_creatures1, 0);
        putCreaturesToOneSideOnABoard(_creatures2, Board.WIDTH - 1);
    }

    private void putCreaturesToOneSideOnABoard(List<Creature> _creatures, int _x) {
        for (int i = 0; i < _creatures.size(); i++) {
            board.add(new Point(_x, i * 2), _creatures.get(i));
        }
    }


    public void move(Point _newPoint) {
        Creature activeCreature = queue.getActiveCreature();
        board.move(activeCreature, _newPoint);
        queue.next();
    }

    public void pass() {
        queue.next();
    }

    public void attack(int _x, int _y) {
        if (board.canAttack(_x, _y)) {
            Creature activeCreature = queue.getActiveCreature();
            activeCreature.attack(board.get(_x, _y));
            queue.next();
        }
    }
}
