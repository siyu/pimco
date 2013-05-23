package pimco;

/**
 * Created with IntelliJ IDEA.
 * User: siyu798
 * Date: 5/22/13
 * Time: 11:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class ObjectTestContainsX implements IObjectTest {
    @Override
    public boolean test(Object o) {
        return o.toString().contains("X");
    }
}
