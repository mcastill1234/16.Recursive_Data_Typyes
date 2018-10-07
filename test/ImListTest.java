import org.junit.Test;
import static org.junit.Assert.*;

public class ImListTest {

    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }

    @Test
    public void testEmptyList() throws Exception {
        ImList<Integer> nil = ImList.empty();
        assertEquals("expected empty list", 0, nil.size());
    }

    @Test
    public void testConsOneElement() throws Exception {
        ImList<Integer> nil = ImList.empty();
        nil.cons(0);
        assertEquals("expected 0",0, nil.size());
    }

    @Test
    public void testConsFirstRestSeveralElements() throws Exception {
        ImList<Integer> nil = ImList.empty();
        ImList<Integer> x = nil.cons(2).cons(1).cons(0);
        int temp0 = x.first();
        int temp1 = x.rest().first();
        int temp2 = x.rest().rest().first();
        assertEquals("expected 0", 0, temp0);
        assertEquals("expected 1", 1, temp1);
        assertEquals("expected 2", 2, temp2);
    }

    @Test
    public void testSizeSeveralElements() throws Exception {
        ImList<Integer> nil = ImList.empty();
        ImList<Integer> x = nil.cons(2).cons(1).cons(0);
        assertEquals("expected 3", 3, x.size());
    }

    @Test
    public void TestIsEmpty() throws Exception {
        ImList<Integer> nil = ImList.empty();
        ImList<Integer> x = nil.cons(2).cons(1).cons(0);
        assertTrue(nil.isEmpty());
        assertFalse(x.isEmpty());
    }

    @Test
    public void TestAppend() throws Exception {
        ImList<Integer> nil = ImList.empty();
        ImList<Integer> x1 = nil.cons(2).cons(1).cons(0);
        ImList<Integer> x2 = nil.cons(3).cons(4).cons(5);
        ImList<Integer> x3 = x1.append(x2);
        int temp = x3.first();
        assertEquals("expected 0", 0, temp);
        assertEquals("expected 6", 6, x3.size());
    }

    @Test
    public void TestContainsEmptyList() throws Exception {
        ImList<Integer> nil = ImList.empty();
        int testElement = 51;
        assertFalse(nil.contains(testElement));
    }

    @Test
    public void TestContainsNonEmptyList() throws Exception {
        ImList<Integer> nil = ImList.empty();
        ImList<Integer> x1 = nil.cons(2).cons(1).cons(0);
        ImList<Integer> x2 = nil.cons(3).cons(4).cons(5);
        assertTrue(x1.contains(1));
        assertTrue(x1.contains(2));
        assertTrue(x2.contains(5));
        assertTrue(x2.contains(3));
        assertFalse(x1.contains(6));
        assertFalse(x2.contains(25));
        assertFalse(x2.contains(-45));
    }

}