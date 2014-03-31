package searchSpace;
import heuristic.*;
import terrain.*;

public class NodeFactory 
{
	private Node masterNode;
	
	public NodeFactory()
	{
		this.masterNode = new Node();
	}
	
	public Node makeNode(char representation)
	{
		Node node = masterNode.makeCopy();
		node .setHeuristic(new ManhattanHeuristic());
		
		if (representation == TerrainInfo.Start.REPRESENTATION)
		{
			FlatlandsTerrain start = new FlatlandsTerrain();
			start.setRepresentation(TerrainInfo.Start.REPRESENTATION);
			start.setDescription(TerrainInfo.Start.DESCRIPTION);
			node.setTerrain(start);
		}
		else if (representation == TerrainInfo.Goal.REPRESENTATION)
		{
			FlatlandsTerrain goal = new FlatlandsTerrain();
			goal.setRepresentation(TerrainInfo.Goal.REPRESENTATION);
			goal.setDescription(TerrainInfo.Goal.DESCRIPTION);
			node.setTerrain(goal);
		}
		else if (representation == TerrainInfo.FlatLands.REPRESENTATION)
		{
			node.setTerrain(new FlatlandsTerrain());
		}
		else if (representation == TerrainInfo.Forest.REPRESENTATION)
		{
			node.setTerrain(new ForestTerrain());
		}
		else if (representation == TerrainInfo.Mountain.REPRESENTATION)
		{
			node.setTerrain(new MountainTerrain());
		}
		else if (representation == TerrainInfo.Water.REPRESENTATION)
		{
			node.setTerrain(new WaterTerrain());
		}
		else
		{
			node = null;
		}

		return node;
	}
}
