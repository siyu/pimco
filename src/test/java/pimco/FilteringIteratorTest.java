package pimco;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: siyu798
 * Date: 5/23/13
 * Time: 12:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class FilteringIteratorTest {

    private List listA;
    private List listB;
    private FilteringIterator iteratorA;
    private FilteringIterator iteratorB;

    @Before
    public void before() {
        listA = new ArrayList<String>();
        listA.add("A");
        listA.add("B");
        listA.add("B");
        iteratorA = new FilteringIterator(listA.iterator(), new ObjectTestContainsX());
        listB = new ArrayList<String>();
        listB.add("A");
        listB.add("BX");
        listB.add("B");
        listB.add("Xg");
        listB.add("y");
        iteratorB = new FilteringIterator(listB.iterator(), new ObjectTestContainsX());
    }


    @Test
    public void testA() {
        assertFalse(iteratorA.hasNext());
    }

    @Test
    public void testB() {
        assertTrue(iteratorB.hasNext());
        assertEquals(iteratorB.next(), "BX");
        assertEquals(iteratorB.next(), "Xg");
        assertFalse(iteratorB.hasNext());
    }
}
