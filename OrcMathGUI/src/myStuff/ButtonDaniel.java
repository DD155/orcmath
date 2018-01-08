package myStuff;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonDaniel extends Button implements ButtonInterfaceDaniel{

	private Color color;

	
	public ButtonDaniel(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text, color, action);
	}

	public ButtonDaniel(int x, int y, int w, int h, String text, Action action) 
	{
		super(x, y, w, h,"",null);

	}

	public void drawButton(Graphics2D g, boolean hover)
	{
		
		 
	}
	@Override
	public void setColor(Color color) 
	{
		this.color = color;
	}

	@Override
	public void highlight() 
	{
		setColor(Color.red);
	}

	@Override
	public void dim() 
	{	
		setColor(color);
	}

}
