package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

class chessTest extends TestCase {
    private int num;

    @BeforeEach
    public void beforeEach() {
        num = 3;
    }

    @Test
    void test() {
        System.out.println(num);
        assertEquals(3, num);
    }

}
