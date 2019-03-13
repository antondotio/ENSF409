
class Colour implements Cloneable
{
    private String colour;
    
	public Colour(String s) {
		colour = new String(s);
	}

	public Object clone() throws CloneNotSupportedException{
		Colour temp = (Colour)super.clone();
		return temp;
	}

    public void setColour(String newColour){
    	colour = newColour;
    }
    
	@Override
	public String toString(){
		return colour;
	}

}
