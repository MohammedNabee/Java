import java.io.IOException;
import java.util.ArrayList;

import display.*;

import searchSpace.*;
import searchTechnique.AStar;
import twoDimensionaCoordinate.Coordinate;


public class tester 
{
	public static void main(String[] args) throws IOException 
	{
		SearchSpace space = SearchSpace.getInstance();//C:\Users\mohammed.nabee\tester.txt
		//C:/Users/mohammed.nabee/Dropbox/java_assignment/LargeMap.txt
		//space.loadSearchSpace("C:/Users/mohammed.nabee/Dropbox/java_assignment/LargeMap.txt");
		//space.printSearchSpace();
		//AStar astar = new AStar();
		//astar.search();
		//space.printPath(space.getGoalNode());
		//System.out.println("===================================================");
	    //space.printSearchSpace();
		
		Display d = new GUIDisplay(space);
		//((GUIDisplay)d).setStatistics(10, 20, 30.9);
		
	}
}
