package pimco;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        List l = new ArrayList<String>();
        l.add("hello");
        l.add("world");
        l.add("ae");
        Iterator<String> i = l.iterator();
        System.out.println(i.next());
        System.out.println(i.next());



        FilteringIterator fi = new FilteringIterator(l.iterator(), new ObjectTestContainsX());

        while (fi.hasNext()) {
            System.out.println(fi.next());
        }
    }
}
