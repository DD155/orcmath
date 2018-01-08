package myStuff;

import danielComponent.CatalogMakerGUI;
import guiPlayer.*;
import guiTeacher.GUIApplication;

public class SimonGameDaniel extends GUIApplication
{
	
	public SimonGameDaniel() 
	{
		super(100, 200);
	}

	public static void main(String[] args)
	{
		SimonGameDaniel gui = new SimonGameDaniel();
		Thread go = new Thread(gui);
		go.start();
	}

	@Override
	public void initScreen()
	{
		SimonScreenDaniel screen = new SimonScreenDaniel(getWidth(), getHeight());
		setScreen(screen);		
	}

	
}
