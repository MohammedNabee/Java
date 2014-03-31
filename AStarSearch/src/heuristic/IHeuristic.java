package heuristic;
import twoDimensionaCoordinate.Coordinate;

public interface IHeuristic 
{
	public float calculateHeuristic(Coordinate start, Coordinate goal);
}
