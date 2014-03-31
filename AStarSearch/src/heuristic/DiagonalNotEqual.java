package heuristic;
import twoDimensionaCoordinate.Coordinate;

public class DiagonalNotEqual implements IHeuristic 
{
	public float calculateHeuristic(Coordinate start, Coordinate goal) 
	{
		float diagonal = Math.min(Math.abs(start.getX()-goal.getX()),Math.abs(start.getY()-goal.getY()) );
		float straight = Math.abs(start.getX()-goal.getX())+Math.abs(start.getY()-goal.getY());
		return (float)Math.sqrt(2.0f)*diagonal+ straight - 2.0f*diagonal;	
	}
}
