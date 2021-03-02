package pl.heroes;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

class CreatureTournQueue {

    private final Collection<Creature> creatures;
    private final Queue<Creature> creatureQueue;
    private Creature activeCreature;

    CreatureTournQueue(Collection<Creature> _creatureCollection) {
        creatures = _creatureCollection;
        creatureQueue = new LinkedList<>();
        initQueue();
        next();
    }

    private void initQueue() {
        creatureQueue.addAll(creatures);
    }

    Creature getActiveCreature() {
        return activeCreature;
    }

    void next() {
        if (creatureQueue.isEmpty()) {
            initQueue();
        }
        activeCreature = creatureQueue. ();
    }
}
