

class Prism extends Rectangle implements Cloneable
{
	private Double height;
	
	public Prism(Double x, Double y, Double l, Double w, Double h, String  name, Colour colour)
	{
		super(x, y, l, w, name, colour);
		height = h;
	}

	public Object clone() throws CloneNotSupportedException{
		Prism temp = (Prism)super.clone();
		return temp;
	}

	public void enlarge(Double n) throws SizeFactorException{
		super.enlarge(n);
		height = height * 2;
	}

	public void shrink (Double n) throws SizeFactorException{
		if(n < LIMIT){
			throw new SizeFactorException(n, LIMIT);
		}
		super.shrink(n);
		height = height / 2;
	}

	public void  set_height(Double h)
	{
		height = h;
	}
	
	public Double  height() 
	{
		return height;
	}
	
	public Double  area()
	{
		return  2 * (length * width) + 2 * (height * length) + 2 * (height * width); 
	}
	
	public Double  perimeter()
	{
		return  width  * 2 + length * 2;
	}
	
	public Double  volume()
	{
		return  width  * length * height;
	}
	
	
	public String toString()
	{
		String s = super.toString()+ "\nHeight: " + height;
		return s;
	}
}