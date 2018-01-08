package myStuff;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonDaniel extends Button implements ButtonInterfaceDaniel{

	private Color color;
//	private boolean highlighted;
	
	public ButtonDaniel(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text, color, action);
	}

	public ButtonDaniel(int x, int y, int w, int h, String text, Action action) 
	{
		super(x, y, w, h,"",null);
		
	}

	public void drawButton(Graphics2D g, boolean hover)
	{
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		drawShape(g, hover);
		g.setColor(color);
		 
	}
	@Override
	public void setColor(Color color) 
	{
		this.color = color;
	}

	@Override
	public void highlight() 
	{
		setColor(Color.YELLOW);
	}

	@Override
	public void dim() 
	{	
		setColor(color);
	}

}
