package terrain;

public class MountainTerrain implements ITerrain 
{
	
	private char representation;
	private double cost;
	private boolean isWalkable;
	private String description;


	public MountainTerrain() 
	{
		this.representation = TerrainInfo.Mountain.REPRESENTATION;
		this.cost = TerrainInfo.Mountain.MOVECOST;
		this.isWalkable = TerrainInfo.Mountain.WALKABLE;
		this.description = TerrainInfo.Mountain.DESCRIPTION;
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
