package pimco;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 * User: siyu798
 * Date: 5/22/13
 * Time: 10:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class FilteringIterator implements Iterator {

    private Iterator<Object> myIterator;
    private IObjectTest objectTest;
    private Object nextElement;
    private boolean hasNext = false;

    public FilteringIterator(Iterator<Object> myIterator, IObjectTest objectTest) {
        this.myIterator = myIterator;
        this.objectTest = objectTest;
    }

    @Override
    public boolean hasNext() {
        if (hasNext)
            return true;
        if (myIterator.hasNext()) {
            Object o = myIterator.next();
            if (objectTest.test(o)) {
                nextElement = o;
                hasNext = true;
                return hasNext();
            }
            else {
                return hasNext();
            }
        }
        return false;
    }

    @Override
    public Object next() {
        if (hasNext) {
            hasNext = false;
            return nextElement;
        }
        if (hasNext())
            return next();
        throw new NoSuchElementException("No more elements!");
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("This operation is not supported");
    }
}
