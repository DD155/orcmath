package myStuff;

import danielComponent.CatalogMakerGUI;
import guiPlayer.*;
import guiTeacher.GUIApplication;

public class SimonGameDaniel extends GUIApplication
{
	
	public SimonGameDaniel(int width, int height) 
	{
		super(width, height);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		SimonGameDaniel gui = new SimonGameDaniel(500,500);
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
