package myStuff;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiTeacher.components.Component;

public class ProgressDaniel extends Component implements ProgressInterfaceDaniel
{

	private int round;
	private int sequence;
	private boolean isOver;

	
	public ProgressDaniel() 
	{
		super(300, 55, 350, 200);
	}


	@Override
	public void gameOver() 
	{
		isOver = true;
		update();
	}

	public void update(Graphics2D g)
	{
		clear();
		if(isOver) 
		{
			g.setColor(Color.black);
			g.drawString("You Are on Round: "+round, 50, 105);
			g.drawString("Sequence: "+sequence, 30, 20);
			g.drawString("Game Over.", 55, 150);
		}
		else
		{
			g.setColor(Color.orange);
			g.drawString("Round: "+round, 5, 55);
			g.drawString("Sequence: "+sequence, 30, 20);
		}	
	}


	@Override
	public void setNum(int round, int sequence) 
	{
		this.round = round;
		this.sequence = sequence;
		update();
		
	}
}