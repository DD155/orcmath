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
		update();

	}

	@Override
	public void setColor(Color color) 
	{
		this.color = color;
		this.setBackground(color);
		update();
	}

	@Override
	public void highlight() 
	{
		this.setBackground(Color.yellow);
		update();
	}

	@Override
	public void dim() 
	{	
		this.setBackground(this.color);
		update();
	}

}
