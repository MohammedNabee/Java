package display;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JLabel;

import searchSpace.*;

public class FileDisplay extends Display 
{

	private double time;
	private int moves;
	private double cost;

	public FileDisplay(ISearchSpace searchSpace) 
	{
		super(searchSpace);
	}

	public void displaySearchSpace() 
	{
		File file = new File(outputFile);
		PrintWriter writer = null;
		try 
		{
			writer = new PrintWriter(file);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		int yLen = displayableSpace.getVerticalLength();
		ArrayList<ArrayList<Node>> matrix = displayableSpace.getNodeMatrix();
		for (int y = 0; y < yLen; y++)
		{
			ArrayList<Node> list = matrix.get(y);
			int xLen = list.size();
			for (int x = 0; x < xLen; x++)
			{
				writer.print(list.get(x).getRepresentation());
			}
			writer.println();
		}
        
		writer.println();
		writer.println("=============================");
		writer.println("Time (ms) : "+this.time);
		writer.println("Number of moves: "+this.moves);
		writer.println("Total cost of path: "+this.cost);
		writer.println("=============================");
        writer.close();
	}
	
	public void setStatistics (double time, int moves, double cost)
	{
		this.time = time;
		this.moves = moves;
		this.cost = cost;
	}
}
