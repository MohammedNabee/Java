package searchSpace;

import java.io.IOException;
import java.util.ArrayList;

import twoDimensionaCoordinate.Coordinate;

public interface ISearchSpace 
{
	public void loadSearchSpace(String filePath) throws IOException;
	public void resetSearchSpace();
	public ArrayList<ArrayList<Node>> getNodeMatrix();
	public Node getStartNode();
	public Node getGoalNode();
	public Node getNode(Coordinate coordinate);
	public void printSearchSpace();
	public int getHorizontalLength();
	public int getVerticalLength();
	public void printPath(Node goal);
	public int numberOfMovesToGoal();
	public double costOfMovesToGoal();
}
