package terrain;

public class FlatlandsTerrain implements ITerrain 
{
	
	private char representation;
	private double cost;
	private boolean isWalkable;
	private String description;


	public FlatlandsTerrain() 
	{
		this.representation = TerrainInfo.FlatLands.REPRESENTATION;
		this.cost = TerrainInfo.FlatLands.MOVECOST;
		this.isWalkable = TerrainInfo.FlatLands.WALKABLE;
		this.description = TerrainInfo.FlatLands.DESCRIPTION;
	}
	
	public double getCost() 
	{
		return this.cost;
	}
	
	public void setCost(double cost)
	{
		this.cost = cost;
	}

	public char getRepresentation() 
	{	
		return this.representation;
	}

	public void setRepresentation(char representation)
	{
		this.representation = representation;
	}
	
	public boolean getIsWalkable() 
	{
		return this.isWalkable;
	}
	
	public void setIsWalkable(boolean isWalkable)
	{
		this.isWalkable = isWalkable;
	}

	public String getDescription() 
	{
		return this.description;
	}

	public void setDescription(String description) 
	{
	    this.description = description;	
	}

}
