package display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import searchSpace.ISearchSpace;
import searchSpace.Node;
import searchTechnique.AStar;

public class GUIDisplay extends Display
{
	private JLabel timeLbl = new JLabel();
	private JLabel movesLbl = new JLabel();
	private JLabel costLbl = new JLabel();
	private JButton button = new JButton("Open");
	JPanel pathPanel = new JPanel();
	JScrollPane scrollPane = new JScrollPane();
	JPanel holderPanel = new JPanel();
	JPanel statsPanel = new JPanel();
	JPanel btnPanel = new JPanel();
	
	
	public GUIDisplay(ISearchSpace searchSpace) 
	{
		super(searchSpace);
		displaySearchSpace();

		/* the frame configuration */
		super.setTitle("AStar Optimal Path");
		super.setSize(400, 500);
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setVisible(true);
		
		button.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e) 
            {
            	if (displayableSpace.getVerticalLength() == 0 || inputfile.isEmpty())
            	{
            		JFileChooser fileChooser = new JFileChooser();
            		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            		{
            			File file = fileChooser.getSelectedFile();
            			inputfile = file.getAbsolutePath();
            			int idx = inputfile.lastIndexOf('\\');
            			outputFile = inputfile.substring(0,idx) + "\\output.txt";
            			
            			try 
            			{
							displayableSpace.loadSearchSpace(inputfile);
							populate();
							
						} 
            			catch (IOException e1) 
						{
							e1.printStackTrace();
						}
            		}
            		button.setText("Calculate");
            	}
            	else if (button.getText().equals("Calculate"))
            	{
            		AStar astar = new AStar();
            		long startTime = System.currentTimeMillis();
            		astar.search();
            		long endTime = System.currentTimeMillis();
            		displayableSpace.printPath(displayableSpace.getGoalNode());
            		populate();
            		setStatistics (endTime-startTime,
            				displayableSpace.numberOfMovesToGoal(), 
            				displayableSpace.costOfMovesToGoal());
            		button.setText("Exit");
            		Display fileDisplay = new FileDisplay(displayableSpace);
            		((FileDisplay)fileDisplay).setStatistics (endTime-startTime,
            				displayableSpace.numberOfMovesToGoal(), 
            				displayableSpace.costOfMovesToGoal());
            		fileDisplay.displaySearchSpace();
            	}
            	else if (button.getText().equals("Exit"))
            	{
            		System.exit(0);
            	}
            }
        });
		
	}

	public void displaySearchSpace() 
	{
		/* Setup the GUI display */
		/* Create the panels */


		/* Set the panel layouts */
		holderPanel.setLayout(new BorderLayout());
		statsPanel.setLayout(new GridLayout(3,2,5,2));

		populate();
		/*if (displayableSpace.getVerticalLength() != 0)
		{
			System.out.println("iM HERE");
			pathPanel.setLayout(new GridLayout(displayableSpace.getVerticalLength(),
					displayableSpace.getHorizontalLength()));

			/* display the search space on the frame 
			int yLen = displayableSpace.getVerticalLength();
			ArrayList<ArrayList<Node>> matrix = displayableSpace.getNodeMatrix();
			for (int y = 0; y < yLen; y++)
			{
				ArrayList<Node> list = matrix.get(y);
				int xLen = list.size();
				for (int x = 0; x < xLen; x++)
				{
					JLabel lbl = new JLabel(""+list.get(x).getRepresentation());
					pathPanel.add(lbl);
				}
			}
		}*/
	

		
		/* Add the statistic fields to the frame */

		statsPanel.setBorder(new TitledBorder("Statistics"));
		statsPanel.add(new JLabel("Time (ms) :"));
		statsPanel.add(timeLbl);
		statsPanel.add(new JLabel("Number of moves :"));
		statsPanel.add(movesLbl);
		statsPanel.add(new JLabel("Total Cost of Path :"));
		statsPanel.add(costLbl);

		/* Add the button to the button panel */
		button.setMaximumSize(getMaximumSize());
		button.setFocusable(true);
		btnPanel.add(button);
		btnPanel.setBorder(new LineBorder(Color.BLACK));

		/* Add components to the frame */
		//scrollPane.add(pathPanel);
		//scrollPane = new JScrollPane(pathPanel);
		JPanel p = new JPanel(new FlowLayout());
		p.add(statsPanel);
		p.add(button);
		holderPanel.add(p, BorderLayout.SOUTH);
		holderPanel.add(scrollPane, BorderLayout.CENTER);
		super.add(holderPanel);
	}

	public void setStatistics (double time, int moves, double cost)
	{
		this.timeLbl.setText(""+time);
		this.movesLbl.setText(""+moves);
		this.costLbl.setText(""+cost);
	}
	
	public void populate()
	{
		if (displayableSpace.getVerticalLength() != 0)
		{
			System.out.println("iM HERE");
			pathPanel.removeAll();
			pathPanel.setLayout(new GridLayout(displayableSpace.getVerticalLength(),
					displayableSpace.getHorizontalLength()));

			/* display the search space on the frame */
			int yLen = displayableSpace.getVerticalLength();
			ArrayList<ArrayList<Node>> matrix = displayableSpace.getNodeMatrix();
			for (int y = 0; y < yLen; y++)
			{
				ArrayList<Node> list = matrix.get(y);
				int xLen = list.size();
				for (int x = 0; x < xLen; x++)
				{
					JLabel lbl = new JLabel(""+list.get(x).getRepresentation());
					pathPanel.add(lbl);
				}
			}
			scrollPane.setViewportView(pathPanel);
		}
	}
}
