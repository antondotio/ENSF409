
class Text implements Cloneable, Resizable
{
	
	private final Double DEFAULT_SIZE = 10.0;
	
    private Colour colour;
    private Double fontSize;
    
    private String text;


	public Text(String text) {
       this.text = text;
       fontSize = DEFAULT_SIZE;
	}

	public Object clone() throws CloneNotSupportedException{
		Text temp = (Text)super.clone();
		if(colour != null){
			temp.colour = (Colour)colour.clone();
		}
		return temp;
	}

	public void enlarge(Double n) throws SizeFactorException{
		if(n < LIMIT){
			throw new SizeFactorException(n, LIMIT);
		}
		fontSize = n * fontSize;
	}

	public void shrink(Double n) throws SizeFactorException{
		if(n < LIMIT){
			throw new SizeFactorException(n, LIMIT);
		}
		fontSize = fontSize / n;
	}

	public Double getFontSize(){
		return fontSize;
	}
	
	public void setColour(String s){
		colour = new Colour(s);
	}
	
	public void setText(String newText){
		text = newText;
	}
	
	public String getText(){
		return text ;
	}
	
	@Override
	public String toString(){
		return (text);
	}

       
}
