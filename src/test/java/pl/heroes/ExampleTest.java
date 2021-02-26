import org.junit.jupiter.api.Test;
import pl.heroes.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExampleTest {
    @Test
    void helloWorld() {
        Point point = new Point(1, 1);
        int x = point.getX();
        assertEquals(1, x);
    }
}
