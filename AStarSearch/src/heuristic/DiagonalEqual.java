package heuristic;
import twoDimensionaCoordinate.Coordinate;

public class DiagonalEqual implements IHeuristic 
{
	public float calculateHeuristic(Coordinate start, Coordinate goal) 
	{
		int horizontal = Math.abs(start.getX()-goal.getX());
		int vertical = Math.abs(start.getY()-goal.getY());
		return Math.max(horizontal, vertical);
	}

}
