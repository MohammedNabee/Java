package searchSpace;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import terrain.TerrainInfo;
import twoDimensionaCoordinate.*;

public class SearchSpace implements ISearchSpace
{
   	private static SearchSpace singleton = null;	
	private ArrayList<ArrayList<Node>> nodeMatrix = new ArrayList<ArrayList<Node>>();
	private NodeFactory nodeFactory = new NodeFactory();
	private Node startNode = null;
	private Node goalNode = null;
	private int noOfMoves;
   	
   	private SearchSpace(){}
   	
   	public static SearchSpace getInstance()
   	{
   		if (singleton == null)
   		{
   			singleton = new SearchSpace();
   		}
   		
   		return singleton;
   	}
   	
   	public void loadSearchSpace(String filePath) throws IOException
   	{
   		Scanner scanner = new Scanner(new FileInputStream(filePath));
   	    try
   	    {
   	        while (scanner.hasNextLine())
   	        {
   	            String line = scanner.nextLine();
   	            int lineLength = line.length();
   	            ArrayList<Node> list = new ArrayList<Node>();
   	            int y = 0;
   	            for (int x = 0; x < lineLength; x++) 
   	            {
   	            	Node node = nodeFactory.makeNode(line.charAt(x));
   	            	node.setCoordinate(new Coordinate(x,y));
   	            	list.add(node);
   	            	
   	            	/* Check if start of goal state */
   	            	if (node.getRepresentation() == '@')
   	            	{
   	            		this.startNode = node;
   	            	}
   	            	else if (node.getRepresentation() == 'X' ||
   	            			 node.getRepresentation() == 'x')
   	            	{
   	            		this.goalNode = node;
   	            	}
   	            }
   	            nodeMatrix.add(list);
   	        }
   	    }
   	    finally
   	    {
   	         scanner.close();
   	    }
   	    generateSurroundings();
   	}
   	
   	private void generateSurroundings()
   	{
   		int yLen = nodeMatrix.size();
   		for (int y = 0; y < yLen; y++)
	    {
	        int xLen = nodeMatrix.get(y).size();
   			for (int x = 0; x < xLen; x++) 
	        {
   				/* Generate the surrounding coordinates */
   				ArrayList<Coordinate> surroundings = new ArrayList<Coordinate>();
   				for (int tempY = y-1; tempY <= y+1; tempY++)
   				{
   					if (getNode(new Coordinate(x-1,tempY)) != null)
   					{
   					    if (getNode(new Coordinate(x-1,tempY)).isWalkable())
   						   surroundings.add(new Coordinate(x-1,tempY));
   					}
   					/* Don't generate the same node as its surrounding */
   					if (tempY != y)
   					{
   					   if (getNode(new Coordinate(x,tempY)) != null)
   					   {
   						   if (getNode(new Coordinate(x,tempY)).isWalkable())
   						       surroundings.add(new Coordinate(x,tempY));
   					   }
   					}
   					
   					if (getNode(new Coordinate(x+1,tempY)) != null)
   					{
   						if (getNode(new Coordinate(x+1,tempY)).isWalkable())
   						   surroundings.add(new Coordinate(x+1,tempY));
   					}
   				}
   				nodeMatrix.get(y).get(x).setSurroundings(surroundings);
	        }
	     }
   	}
   	
   	public Node getNode(Coordinate coordinate)
   	{
   		if (coordinate.getY() < 0 || coordinate.getY() >= nodeMatrix.size())
   		{
   			return null;
   		}
   		else if (coordinate.getX() < 0 || 
   		coordinate.getX() >= nodeMatrix.get(coordinate.getY()).size())
   		{
   			return null;
   		}
   		else
   		{
   			return this.nodeMatrix.get(coordinate.getY()).get(coordinate.getX());
   		}
   	}
   	
   	public void resetSearchSpace()
   	{
   	   this.nodeMatrix = new ArrayList<ArrayList<Node>>();	
   	}
   	
   	public ArrayList<ArrayList<Node>> getNodeMatrix()
   	{
   		return this.nodeMatrix;
   	}
   	
   	public void printSearchSpace()
   	{
   		int yLen = nodeMatrix.size();
   		for (int y = 0; y < yLen; y++)
   		{
   			ArrayList<Node> horizontalMatrix = nodeMatrix.get(y);
   			int xLen = horizontalMatrix.size();
   			for (int x = 0; x < xLen; x++)
   			{
   				System.out.print(horizontalMatrix.get(x).getRepresentation());
   			}
   			System.out.println();
   		}
   	}

	public Node getStartNode() 
	{
		return this.startNode;
	}

	public Node getGoalNode() 
	{
		return this.goalNode;
	}
	
	public void printPath(Node target)
	{
        for(Node node = target; node!=null; node = node.getParentNode())
        {
            node.setRepresentation(TerrainInfo.SHORTEST_PATH_REPRESENTATION);
            this.noOfMoves ++;
        }
    }
	
	public int getHorizontalLength()
	{
		int horizontalLen = 0;
		for (int i = 0; i < this.nodeMatrix.size(); i++)
		{
			if (this.nodeMatrix.get(i).size() > horizontalLen)
			{
				horizontalLen = this.nodeMatrix.get(i).size();
			}
		}
		return horizontalLen;
	}
	
	public int getVerticalLength()
	{
		return this.nodeMatrix.size();
	}

	public int numberOfMovesToGoal() 
	{
		return this.noOfMoves;
	}

	public double costOfMovesToGoal() 
	{
		return this.goalNode.getScore();
	}

}
