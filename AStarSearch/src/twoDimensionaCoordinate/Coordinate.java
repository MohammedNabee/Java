package twoDimensionaCoordinate;

public class Coordinate 
{

	private int x,y;
	
	public Coordinate (int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int getX ()
	{
		return this.x;
	}
	
	public void setX(int x)
	{
	    this.x = x;	
	}
	
	public int getY ()
	{
		return this.y;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}

	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
}
