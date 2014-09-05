import static org.junit.Assert.*;

import java.io.InvalidObjectException;

public class Program {
	private static final double MAX_DELTA = 1e-15;
    public static void main(String[] args) throws InvalidObjectException {
    	double zero = 0.0;
    	
        Vector v = new Vector();
        
        assertEquals(zero, v.getX(), MAX_DELTA);
        assertEquals(zero, v.getY(), MAX_DELTA);
        assertEquals(zero, v.getZ(), MAX_DELTA);
        
        v.setX(1);
        v.setY(1);
        Vector perp = v.findRandomPerpendicular();
        System.out.println(v.toString());
        System.out.println(perp.toString());
        System.out.println(v.angleTo(perp)); // TODO: should be 90
    }

}
