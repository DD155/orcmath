package myStuff;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiTeacher.components.Component;

public class ProgressDaniel extends Component implements ProgressInterfaceDaniel
{

	private int round;
	private int sequence;
	private boolean isOver;
	private int x;
	private int y;
	
	public ProgressDaniel(int x, int y, int w, int h) 
	{
		super(x, y, w, h);
		this.x = x;
		this.y = y;
		isOver = false;
		round = 1;
		sequence = 1;
	}


	@Override
	public void gameOver() 
	{
		isOver = true;
	}

	@Override
	public void setRound(int round)
	{
		this.round = round;
	}

	@Override
	public void setSequenceSize(int size)
	{
		sequence = size;
	}

	@Override
	public void update(Graphics2D g)
	{
		if(!isOver) 
		{
			g.drawString(""+round, x, y);
			g.drawString(""+sequence, x+15, y+20);
		}
		else 
		{
			g.drawString("Game Over.", x+10, y+10);
		}		
	}
}
