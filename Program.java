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
        v.setZ(1);
        
        assertEquals(90.0, v.angleTo(v.findRandomPerpendicular()), MAX_DELTA);
    }

}
