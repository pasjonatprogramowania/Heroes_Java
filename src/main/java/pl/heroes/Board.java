package pl.heroes;

import java.util.HashMap;
import java.util.Map;

class Board {


    public final static int WIDTH = 20;
    public final static int HEIGHT = 15;
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

    Point get(Creature _creature) {
        for (Map.Entry<Point, Creature> entry : map.entrySet()) {
            if (_creature.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    private void isThisTileTaken(Point _point) {
        if (map.containsKey(_point)) throw new IllegalArgumentException();
    }

    private void isThisTileOnMap(Point _point) {
        if (_point.getY() > HEIGHT || _point.getX() > WIDTH) throw new IllegalArgumentException();
    }

    void move(Creature _creature, Point _newPoint) {
        move(get(_creature), _newPoint);
    }

    void move(Point _point, Point _newPoint) {
        isThisTileOnMap(_newPoint);
        isThisTileTaken(_newPoint);

        Creature creature = map.get(_point);
        map.remove(_point);
        map.put(_newPoint, creature);
    }

}
