package pl.heroes;

import java.util.HashMap;
import java.util.Map;

class Board {

    private static int boardX = 20;
    private static int boardY = 15;
    private Map<Point, Creature> map;

    Board() {
        map = new HashMap<>();
    }

    void add(Point _point, Creature _creature) {
        isThisTileOnMap(_point);
        isThisTileTaken(_point);

        map.put(_point, _creature);
    }

    Creature get(int _x, int _y) {
        return map.get(new Point(_x, _y));
    }

    private void isThisTileTaken(Point _point) {
        if (map.containsKey(_point)) throw new IllegalArgumentException();
    }

    private void isThisTileOnMap(Point _point) {
        if (_point.getY() > boardY || _point.getX() > boardX) throw new IllegalArgumentException();
    }

    void move(Point _point, Point _newPoint) {
        isThisTileOnMap(_newPoint);
        isThisTileTaken(_newPoint);

        Creature creature = map.get(_point);
        map.remove(_point);
        map.put(_newPoint, creature);
    }
}
