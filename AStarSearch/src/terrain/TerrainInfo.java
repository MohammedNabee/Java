package terrain;

public class TerrainInfo 
{
	public static final int NOT_APPLICABLE = -1;
	public static final char SHORTEST_PATH_REPRESENTATION = '#';
	
	public static class FlatLands
	{
		public static final char REPRESENTATION = '.';
		public static final double MOVECOST = 1.0;
		public static final boolean WALKABLE = true;
		public static final String DESCRIPTION = "FlatLands";
	}
	
	public static class Forest
	{
		public static final char REPRESENTATION = '*';
		public static final double MOVECOST = 2.0;
		public static final boolean WALKABLE = true;
		public static final String DESCRIPTION = "Forest";
	}
	
	public static class Mountain
	{
		public static final char REPRESENTATION = '^';
		public static final double MOVECOST = 3.0;
		public static final boolean WALKABLE = true;
		public static final String DESCRIPTION = "Mountain";
	}
	
	public static class Water
	{
		public static final char REPRESENTATION = '~';
		public static final double MOVECOST = NOT_APPLICABLE;
		public static final boolean WALKABLE = false;
		public static final String DESCRIPTION = "Water";
	}
	
	public static class Start
	{
		public static final char REPRESENTATION = '@';
		public static final double MOVECOST = 1.0;
		public static final boolean WALKABLE = true;
		public static final String DESCRIPTION = "Start State";
	}
	
	public static class Goal
	{
		public static final char REPRESENTATION = 'X';
		public static final double MOVECOST = 1.0;
		public static final boolean WALKABLE = true;
		public static final String DESCRIPTION = "Goal State";
	}

}
