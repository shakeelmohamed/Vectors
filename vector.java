public class vector {
	private double x,y,z;
	//Method to return a unit vector (magnitude 1)
	public vector(){
		this.setX(this.setY(this.setZ(0)));
	}
	
	public vector(double x, double y, double z) {
		this.setX(x);
		this.setY(y);
		this.setZ(z);
	}
	
	public vector(vector v) {
		this.setX(v.getX());
		this.setY(v.getY());
		this.setZ(v.getZ());
	}
	
	public double magnitude(){
		double mag;
		mag = (this.getX() * this.getX()) + (this.getY() * this.getY()) + (this.getZ() * this.getZ());
		mag = Math.sqrt(mag);
		return mag;
	}
	
	public String exactMagnitude(){
		double squaredSum = (Math.pow(this.getX(),2)+Math.pow(this.getY(),2)+Math.pow(this.getZ(),2));
		return "Sqrt("+squaredSum+")";
	}
	
	public String getUnitVector(){
		//Fill this in with some code to check for non-decimal components of the unit vector, eg: <1,0,0>
		return("<"+this.getX()+"/"+this.exactMagnitude()+", "+this.getY()+"/"+this.exactMagnitude()+", "+this.getZ()+"/"+this.exactMagnitude()+">");
	}
	
	public vector scaleTo(double scale){
		vector scaled = new vector();
		scaled.setX(this.getX()*scale);
		scaled.setY(this.getY()*scale);
		scaled.setZ(this.getZ()*scale);
		return scaled;
	}
	
	public String standardVectorNotation(){
		return(this.getX()+"i + "+this.getY()+"j + "+this.getZ()+"k ");
	}
	
	public String toString(){
		return("<"+this.getX()+", "+this.getY()+", "+this.getZ()+">");
	}
	
	public boolean equals(vector v2){
		if((this.x == v2.x) && (this.y == v2.y) && (this.z == v2.z)){
				return true;
		}
		else return false;
	}

	public double dot(vector v2) {
		return (this.getX()*v2.getX() + this.getY()*v2.getY() + this.getZ()*v2.getZ());
	}
	
	public vector cross(vector v2) {
		return new vector(this.getY()*v2.getZ() - this.getZ()*v2.getY(), this.getZ()*v2.getX() - this.getX()*v2.getZ(), this.getX()*v2.getY() - this.getY()*v2.getX());
	}
	
	public String angleTo(vector v2){
		if((this.magnitude() == 0) || (v2.magnitude() == 0)) {
			return "";
		}
		else if(this.equals(v2)){
			return "";
		}
		else return ""+(Math.toDegrees(Math.acos(((this.dot(v2))/(this.magnitude()*v2.magnitude())))));
	}
	
	public vector findperp() {
		int x = (int)(Math.random()*10);
		int y = (int)(Math.random()*10);
		double z = -1*(((x*this.getX())+(y*this.getY()))/this.getZ());
		return new vector((double)x,(double)y,(double)z);
	}
	
	public vector projOnto(vector v2) {
		double scalar = this.dot(v2) / (v2.magnitude()*v2.magnitude());
		return v2.scaleTo(scalar);
	}

	public double getX() {
		return x;
	}

	public double setX(double x) {
		this.x = x;
		return x;
	}

	public double getY() {
		return y;
	}

	public double setY(double y) {
		this.y = y;
		return y;
	}

	public double getZ() {
		return z;
	}

	public double setZ(double z) {
		this.z = z;
		return z;
	}

}