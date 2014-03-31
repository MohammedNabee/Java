package heuristic;
import twoDimensionaCoordinate.Coordinate;

public class EuclidianHeuristic implements IHeuristic 
{
	public float calculateHeuristic(Coordinate start, Coordinate goal) 
	{
		return (float)Math.sqrt(Math.pow(start.getX()-goal.getX(), 2)+Math.pow(start.getY()-goal.getY(), 2));
	}

}
