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

        label.setText("");

        nextRound();

    }

	private void nextRound()
	{
		acceptingInput = false;
		roundNumber++;
		move.add(randomMove());
		
		// step 4
		progress.setRound(roundNumber);
		progress.setSequenceSize(move.size());
		
		changeText("Simon's Turn.");
		playSequence();
		changeText("Your Turn.");
		
		acceptingInput = true;
		sequenceIndex = 0;
	}

	private void changeText(String string) 
	{
		label.setText(string);
		try 
		{	
            Thread.sleep(1000);
        }
		catch (InterruptedException e) 
		{
            e.printStackTrace();
        }	
		label.setText("");
		
		
	}

	private void playSequence() 
	{
		ButtonInterfaceDaniel b = null;
		
		for (int i = 0; i < move.size(); i++)
		{
			if (b != null)
			{
				b.dim();			
			}
			b = move.get(i).getButton();
			b.highlight();
			int sleepTime = 10000/roundNumber;
			try 
			{	
	            Thread.sleep(sleepTime);
	        }
			catch (InterruptedException e) 
			{
	            e.printStackTrace();
	        }	
		}
		
		b.dim();
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
		return new ProgressDaniel(0,0,50,50);
	}


	private void addButtons() 
	{
			int numberOfButtons = 4;
			buttons=new ButtonInterfaceDaniel[numberOfButtons];
			Color[] colors= new Color[numberOfButtons];
			colors[0] = Color.green;
			colors[1] = Color.red;
			colors[2] = Color.blue;
			colors[3] = Color.yellow;
			
			for(int i=0;i<numberOfButtons;i++) 
			{
					final ButtonInterfaceDaniel b = getAButton();
					buttons[i] = b;
					b.setColor(colors[i]);
					b.setX(20);
					b.setY(20);
						
					b.setAction(new Action()
					{
						public void act(){
							if(acceptingInput)
							{
								Thread blink = new Thread(new Runnable()
								{
								    public void run(){
		
								        b.highlight();
	
							        try {
	
							            Thread.sleep(800);
	
							        } catch (InterruptedException e) {
								         	
							            e.printStackTrace();
	
							        }
	
							        b.dim();
	
							    }
							});
							blink.start();
							
							if (b == move.get(sequenceIndex).getButton())
							{
								sequenceIndex++;
							}
							else
							{
								progress.gameOver();
							}
							
							if(sequenceIndex == move.size()){
							    Thread nextRound = new Thread(SimonScreenDaniel.this);
							    nextRound.start();
							}
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
		return new ButtonDaniel(70,70,45,50,"",null);
	}

	/**
	Placeholder until partner finishes implementation of MoveInterface
	*/
	private MoveInterfaceDaniel getMove(int bIndex)
	{
	    return new MoveDaniel((ButtonDaniel) buttons[bIndex]);
	}


}
