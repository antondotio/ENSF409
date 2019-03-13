

class Circle extends Shape implements Cloneable
{
	private Double radius;

	Circle(Double x_origin, Double y_origin, Double newradius,  String name, Colour colour){
		super(x_origin, y_origin, name, colour);
		radius = newradius;
	}
	
	public Object clone() throws CloneNotSupportedException{
		Circle temp  = (Circle)super.clone();
		return temp;
	}

	public void enlarge(Double n) throws SizeFactorException{
		if(n < LIMIT){
			throw new SizeFactorException(n, LIMIT);
		}
		radius = radius * 2;
	}

	public void shrink(Double n) throws SizeFactorException{
		if(n < LIMIT){
			throw new SizeFactorException(n, LIMIT);
		}
		radius = radius / 2;
	}

	public void set_radius(Double newradius){
		radius = newradius;
	}
	
	public Double get_radius() {
		return radius;
	}
	
	public Double area() {
		return Math.PI * Math.pow(radius, 2);
	}
	
	public Double perimeter() {
		return 2 * Math.PI * radius;
	}
	
	public Double  volume(){
		return 0.0;
	}
	
	
	public String toString(){
		String s = super.toString()+ "\nRadius: " + radius;
		return s;
	}
         
}