package myStuff;

import guiPlayer.*;
import guiTeacher.GUIApplication;

public class SimonGameDaniel extends GUIApplication
{

	public SimonGameDaniel() 
	{
		super(1, 2);
	}

	public static void main(String[] args)
	{

	}

	@Override
	public void initScreen()
	{
		SimonScreenDaniel screen = new SimonScreenDaniel(getWidth(), getHeight());
		setScreen(screen);		
	}

	
}
