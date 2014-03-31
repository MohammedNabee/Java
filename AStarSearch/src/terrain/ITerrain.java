package terrain;

public interface ITerrain 
{  
	public double getCost();
	public void setCost(double cost);
	public char getRepresentation();
	public void setRepresentation(char representation);
	public String getDescription();
	public void setDescription(String description);
	public boolean getIsWalkable();	
	public void setIsWalkable(boolean isWalkable);
}
