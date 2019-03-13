

class Rectangle extends Shape implements Cloneable
{
	protected Double width, length;
	
	public Rectangle(Double x_origin, Double y_origin, Double newlength, Double newwidth, String  name, Colour colour){
		super(x_origin, y_origin, name, colour);
		length= newlength;
		width =newwidth;
	}

	public Object clone() throws CloneNotSupportedException{
		Rectangle temp = (Rectangle)super.clone();
		return temp;
	}

	public void enlarge(Double n) throws SizeFactorException{
		if(n < LIMIT){
			throw new SizeFactorException(n, LIMIT);
		}
		width = n * width;
		length = n * length;
	}

	public void shrink(Double n) throws SizeFactorException{
		if(n < LIMIT){
			throw new SizeFactorException(n, LIMIT);
		}
		width = width / n;
		length = length / n;
	}
	
	protected void  set_length(Double newlength){
		length = newlength;
	}
	
	protected Double  get_length() {
		return length;
	}
	
	protected Double  area(){
		return  width *length;
	}
	
	protected Double  perimeter(){
		return  width  * 2 + length * 2;
	}
	
	protected Double  volume(){
		return 0.0;
	}
	
	@Override
	public String toString(){
		String s = super.toString()+ "\nWidth: " + width + "\nLength: " + length;
		return s;
	}
        	
}