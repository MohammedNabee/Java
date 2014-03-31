package heuristic;
import twoDimensionaCoordinate.Coordinate;

public class ManhattanHeuristic implements IHeuristic 
{

	public float calculateHeuristic(Coordinate start, Coordinate goal) 
	{	
		return Math.abs(start.getX()-goal.getX())+Math.abs(start.getY()-goal.getY());
	}

}
