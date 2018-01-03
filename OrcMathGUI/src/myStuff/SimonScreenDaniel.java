package myStuff;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.*;

public class SimonScreenDaniel extends ClickableScreen implements Runnable{

	TextLabel label;                                    
	ButtonInterfaceDaniel[] buttons;                        
	ProgressInterfaceDaniel progress;                     
	ArrayList<MoveInterfaceDaniel> move;
	int roundNumber;
	boolean acceptingInput;
	int sequenceIndex;
	int lastSelectedButton;
	
	public SimonScreenDaniel(int width, int height) 
	{
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run()
	{
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects)
	{
		addButtons();
		for(ButtonInterfaceDaniel b: buttons)
		{ 
		    viewObjects.add(b); 
		}
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		move = new ArrayList<MoveInterfaceDaniel>();
		//add 2 moves to start
		lastSelectedButton = -1;
		move.add(randomMove());
		move.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}

	private MoveInterfaceDaniel randomMove() 
	{
		int bIndex = (int)(Math.random()*buttons.length);
	    while(bIndex == lastSelectedButton){
	        bIndex = (int)(Math.random()*buttons.length);
	    }
	    return getMove(bIndex);
	}

	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/

	private ProgressInterfaceDaniel getProgress() 
	{
		return null;
	}

	private void addButtons() 
	{
		int numberOfButtons = 4;
		buttons = new ButtonInterfaceDaniel[numberOfButtons];
		Color[] colors = new Color[numberOfButtons];
		
		
		for (int i = 0; i < numberOfButtons; i++)
		{
			colors[i] = new Color(((int)(Math.random())*255),((int)(Math.random())*255),((int)(Math.random())*255));
			final ButtonInterfaceDaniel b = getAButton();
			buttons[i] = b;
			b.setColor(colors[i]);
			b.setX(10);
			b.setY(10);
			
			b.setAction(new Action()
			{
				public void act(){
					if(acceptingInput)
					{
						Thread blink = new Thread(new Runnable()
						{
							public void run(){
							}
						    	b.highlight();
							});
						}
				}
			});
		}
	}
	/**
	Placeholder until partner finishes implementation of ButtonInterface
	*/
	private ButtonInterfaceDaniel getAButton() 
	{
		return null;
	}

	/**
	Placeholder until partner finishes implementation of MoveInterface
	*/
	private MoveInterfaceDaniel getMove(int bIndex)
	{
	    return null;
	}


}
