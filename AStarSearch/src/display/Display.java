package display;

import java.awt.*;

import javax.swing.*;

import searchSpace.*;

public abstract class Display extends JFrame
{
	protected ISearchSpace displayableSpace;
	protected Color goalColor;
	protected Color startColor;
	protected Color shortestPathColor;
	protected Color nodeColor;
	protected int SearchSpaceWidth;
	protected String inputfile;
	protected String outputFile;
	
	public Display(ISearchSpace displayableSpace)
	{
		this.displayableSpace = displayableSpace;
	}
	
	public void setGoalColor(Color color)
	{
		this.goalColor = color;
	}
	
	public void setStarColor(Color color)
	{
		this.startColor = color;
	}
	
	public void setShortestPathColor(Color color)
	{
		this.shortestPathColor = color;
	}
  
	public void setNodeColor(Color color)
	{
		this.nodeColor = color;
	}
	
	public abstract void displaySearchSpace();
}
