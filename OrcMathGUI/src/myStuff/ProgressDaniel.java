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
		super(250,50,400,200);
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
		if(!isOver) {
			g.setColor(Color.blue);
		g.fillRect(100, 20, 50, 20);
		g.setColor(Color.black);
		g.drawString("Round: "+round,50,105);
		g.drawString("Current Sequence: "+sequence,30,20);
		g.drawString("Game Over.",55,150);
		}else {
		g.setColor(Color.red);
		g.fillRect(100, 20, 50, 20);
		g.setColor(Color.orange);
		g.drawString("Round: "+round,5,55);
		g.drawString("Current Sequence: "+sequence,30,20);
}	
	}


	@Override
	public void setNum(int round, int seq) 
	{
		this.round = round;
		sequence = seq;
		update();
		
	}
}
