package searchSpace;
import java.util.ArrayList;
import terrain.*;
import heuristic.*;
import twoDimensionaCoordinate.*;

public class Node implements Cloneable, /*Comparator<Node>,*/ Comparable<Node>

{
	private Coordinate coordinate;
	private IHeuristic heuristic;
	private ITerrain terrain;
	private ArrayList<Coordinate> surroundings;
	private double score;
	private Node parent;
	
	public Node()
	{
		this.coordinate = null;
		this.heuristic = null;
		this.terrain = null;
		this.surroundings = null;
		this.parent = null;
	}

	public void setCoordinate(Coordinate coordinate) 
	{
		this.coordinate = coordinate;
	}
	
	public Coordinate getCoordinate() 
	{
		return this.coordinate;
	}

	public void setHeuristic(IHeuristic heuristic) 
	{
		this.heuristic = heuristic;
	}
	
	public float getHeuristic(Coordinate goal) 
	{
		return this.heuristic.calculateHeuristic(this.coordinate, goal);
	}
	
	public void setTerrain(ITerrain terrain)
	{
		this.terrain = terrain;
	}
	
	public double getCost() 
	{
		return this.terrain.getCost();
	}
	
	public void setScore(double score)
	{
		this.score = score;
	}
	
	public double getScore()
	{
		return this.score;
	}
	
	public char getRepresentation() 
	{
		return this.terrain.getRepresentation();
	}
	
	public void setRepresentation(char newRepresentation) 
	{
		this.terrain.setRepresentation(newRepresentation);
	}

	public boolean isWalkable()
	{
		return this.terrain.getIsWalkable();
	}

	public void setSurroundings(ArrayList<Coordinate> surroundings) 
	{
		this.surroundings = surroundings;
	}
	
	public ArrayList<Coordinate> getSurroundings() 
	{
		return this.surroundings;
	}

	public void setParentNode(Node parent)
	{
		this.parent = parent;
	}
	
	public Node getParentNode()
	{
		return this.parent;
	}
	
	public void addAsSurrounding(Coordinate coordinate)
	{
		if (coordinate != null)
		{
			this.surroundings.add(coordinate);
		}
	}
	
	public Node makeCopy()
	{
		Node node = null;
		
		try 
		{
			node = (Node) this.clone();
		} 
		catch (CloneNotSupportedException e) 
		{
			e.printStackTrace();
		}
		
		return node;
	}

	public int compareTo(Node o) 
	{
        if(this.getScore() > o.getScore())
        {
            return 1;
        }

        else if (this.getScore() < o.getScore())
        {
            return -1;
        }

        else
        {
            return 0;
        }
	}

}
