package searchTechnique;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import searchSpace.*;
import twoDimensionaCoordinate.Coordinate;


public class AStar implements ISearchTechnique 
{
	private ISearchSpace searchSpace = null;
	private Node startState = null;
	private Node goalState = null;
	
	public AStar()
	{
		this.searchSpace = SearchSpace.getInstance();
		this.startState = searchSpace.getStartNode();
		this.goalState = searchSpace.getGoalNode();
	}
	
	public void search() 
	{
			 
        Set<Node> explored = new HashSet<Node>();
        PriorityQueue<Node> queue = new PriorityQueue<Node>();

        //cost from start
        startState.setScore(0);
        queue.add(startState);
        boolean found = false;

        while((!queue.isEmpty())&&(!found)){

           //the node in having the lowest f_score value
           Node current = queue.poll();
           explored.add(current);

           //goal found
           if(current.getRepresentation() == searchSpace.getGoalNode().getRepresentation())
           {
               found = true;
           }

           //check every child of current node
           for(Coordinate coordinate : current.getSurroundings())
           {
               Node child = searchSpace.getNode(coordinate);
               double temp_g_scores = current.getScore() + child.getCost();
               double temp_f_scores = temp_g_scores + child.getHeuristic(this.goalState.getCoordinate());

               /*if child node has been evaluated and the newer f_score is higher, skip*/            
               if((explored.contains(child)) && (temp_f_scores >= child.getScore()))
               {
                   continue;
               }
               /*else if child node is not in queue or newer f_score is lower*/
               else if((!queue.contains(child)) || (temp_f_scores < child.getScore()))
               {
            	   child.setParentNode(current);
                   child.setScore(temp_f_scores);

                   if(queue.contains(child))
                   {
                       queue.remove(child);
                   }

                   queue.add(child);
               }
            }
        }
	}
}
