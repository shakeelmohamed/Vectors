import java.io.InvalidObjectException;

public class Vector {
    private double x, y, z;
    
    public static Vector UNIT_VECTOR_X = new Vector(1, 0, 0);
    public static Vector UNIT_VECTOR_Y = new Vector(0, 1, 0);
    public static Vector UNIT_VECTOR_Z = new Vector(0, 0, 1);
    
    public Vector() {
        this.x = this.y = this.z = 0.0;
    }

    public Vector(double x, double y, double z) {
    	this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector(Vector v) {
        this.setX(v.getX());
        this.setY(v.getY());
        this.setZ(v.getZ());
    }

    public double magnitude() {
        return Math.sqrt((x * x) + (y * y) + (z * z));
    }

    public String exactMagnitude() {
        double squaredSum = (x * x) + (y * y) + (z * z);
        return "Sqrt(" + squaredSum + ")";
    }

    public String getUnitVector() {
        // TODO: Fill this in with some code to check for non-decimal components of
        // the unit vector, eg: <1,0,0>
    	String exactMag = this.exactMagnitude();
        return ("<" + x + "/" + exactMag + ", " + y + "/" + exactMag + ", " + z + "/" + exactMag + ">");
    }

    public Vector scaleTo(double scale) {
        return new Vector(x * scale, y * scale, z * scale);
    }

    public String standardVectorNotation() {
        return (x + "i + " + y + "j + " + z + "k ");
    }

    public String toString() {
        return ("<" + x + ", " + y + ", " + z + ">");
    }

    public boolean equals(Vector v) {
    	return (x == v.x) && (y == v.y) && (z == v.z);
    }

    public double dotProduct(Vector v) {
        return x * v.getX() + y * v.getY() + z * v.getZ();
    }

    public Vector crossProduct(Vector v) {
        return new Vector(y * v.getZ() - z * v.getY(),
                		z * v.getX() - x * v.getZ(),
                		x * v.getY() - y * v.getX());
    }

    public double angleTo(Vector v) throws InvalidObjectException {
        if (this.equals(v)) {
            throw new InvalidObjectException("Both vectors are the same.");
        }
        else if (this.magnitude() == 0 || v.magnitude() == 0) {
        	throw new InvalidObjectException("One of the vectors has a magnitude of zero.");
        }
        return Math.toDegrees(Math.acos(((this.dotProduct(v)) / (this
                            .magnitude() * v.magnitude()))));
    }

    public Vector findRandomPerpendicular() {
    	// TODO: this might not be correct
        int x = (int) (Math.random() * 10);
        int y = (int) (Math.random() * 10);
        double z = -1 * (((x * this.getX()) + (y * this.getY())) / this.getZ());
        if (this.getZ() == 0.0) {
        	z = 0.0;
        }
        return new Vector((double) x, (double) y, (double) z);
    }

    public Vector projectOnto(Vector v) {
        double scalar = this.dotProduct(v) / (v.magnitude() * v.magnitude());
        return v.scaleTo(scalar);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

}