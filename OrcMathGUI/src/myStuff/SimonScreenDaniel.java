/*

package myStuff;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.*;

public class SimonScreenDaniel extends ClickableScreen implements Runnable{

	
	private TextLabel label;                                    
	private ButtonInterfaceDaniel[] buttons;                        
	private ProgressInterfaceDaniel progress;                     
	private ArrayList<MoveInterfaceDaniel> move;
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;
	public int oldButton;
	private ButtonInterfaceDaniel[] allButtons;
	private Color[] colors;
	
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
			b = move.get(i).getTheButton();
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
		
		move = new ArrayList<MoveInterfaceDaniel>();
		oldButton = -1;
		allButtons = new ButtonInterfaceDaniel[4];
		colors = new Color[4];
		colors[0] = Color.BLUE;
		colors[1] = Color.YELLOW;
		colors[2] = Color.RED;
		colors[3] = Color.GREEN;
	
		roundNumber = 0;
		sequenceIndex = 0;
		sequenceIndex= 3;
		acceptingInput = true;
		
		
		label = new TextLabel(50,30,200,100,"TIME TO PLAY SIMON FOLLOW MY STEPS!!");
		viewObjects.add(label);
		
		for (int i = 0;i <allButtons.length;i++) {
			
			final ButtonInterfaceDaniel button = getButton(50,i*70+70,60,60);
			allButtons[i] = button;
			button.setColor(colors[i]);
			button.setAction(new Action() {
				
				@Override
				public void act() {
					if (acceptingInput) {
						Thread light  = new Thread(new Runnable() {
							
							@Override
							public void run() {
								button.highlight();
								acceptingInput = false;
								try {
									Thread.sleep(800);
								}catch(InterruptedException e ) {
									e.printStackTrace();
								}
								acceptingInput = true;
								button.dim();
							}
						});
						light.start();
						if(button == move.get(sequenceIndex).getTheButton()) { // correct input
							sequenceIndex++;
						} else{ // wrong input
							progress.gameOver();
							acceptingInput = false;
						}
						if(sequenceIndex == move.size()){ // got all correct
						    Thread nextRound = new Thread(SimonScreenDaniel.this); 
						    nextRound.start(); 
						}
					}
					
				}
			});
		}
		
		progress = getProgress();
		progress.setNum(roundNumber,sequenceIndex);
		move.add(randomMove());
		move.add(randomMove());

		for (int i = 0;i <allButtons.length;i++) {
			System.out.println(allButtons[i]);
			viewObjects.add(allButtons[i]);
		}
		viewObjects.add(progress);
	}

	private ButtonInterfaceDaniel getButton(int x, int y, int w, int h) 
	{
		ButtonDaniel button = new ButtonDaniel(x,y,w,h,"",null);
		return button;
	}

	private MoveInterfaceDaniel randomMove() 
	{
		int bIndex = (int)(Math.random()*buttons.length);
	    while(bIndex == lastSelectedButton){
	        bIndex = (int)(Math.random()*buttons.length);
	    }
	    return getMove(bIndex);
	}


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
							
							if (b == move.get(sequenceIndex).getTheButton())
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

	private ButtonInterfaceDaniel getAButton() 
	{
		return new ButtonDaniel(70,70,45,50,"",null);
	}

	
	private MoveInterfaceDaniel getMove(int bIndex)
	{
	    return new MoveDaniel((ButtonDaniel) buttons[bIndex]);
	}


}

*/

package myStuff;

import java.util.ArrayList;
import java.awt.Color;
import java.util.List;



import guiTeacher.components.Action;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenDaniel extends ClickableScreen implements Runnable {

	public ArrayList<MoveInterfaceDaniel> move;
	public ProgressInterfaceDaniel progress;
	
	public int win;
	public int round;
	public int sequence;
	public ButtonInterfaceDaniel[] buttons;	
	public int previous;	
	public boolean input;		
	Color[] colors;	
	public TextLabel label;
	
	public SimonScreenDaniel(int width, int height) 
	{
		super(width, height);		
		Thread app = new Thread(this);
		app.start();
	}
	

	public void run() 
	{
		input = false;
		round++;
		win++;	
		
		progress.setNum(round, move.size());
		move.add(getRandomMove());
		
		label.setText("Follow Me.");
		
		input();
		
		label.setText("Repeat it.");
		sequence = 0;
		input = true;
		
	}
	
	public void input(){
		ButtonInterfaceDaniel b;
		for(int i = 0; i < move.size(); i++) {
			b = move.get(i).getButton();
			b.highlight();
			try {
				Thread.sleep((int)(1000*round));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			b.dim();
		}
		
	}
	
	 
	@Override
	public void initAllObjects(List<Visible> viewObjects)
	{
		move = new ArrayList<MoveInterfaceDaniel>();
		previous = -1;
		buttons = new ButtonInterfaceDaniel[4];
		colors = new Color[4];
		colors[0] = Color.green;
		colors[1] = Color.orange;
		colors[2] = Color.blue;
		colors[3] = Color.gray;
	
		round = 0;
		sequence = 0;
		win = 3;
		input = true;
		
		
		label = new TextLabel(70,50,150,100,"Let's Play! Follow Me.");
		viewObjects.add(label);
		
		for (int i = 0; i < buttons.length; i++) 
		{
			
			final ButtonInterfaceDaniel button = getButton(50,i*70+70,60,60);
			buttons[i] = button;
			button.setColor(colors[i]);
			button.setAction(new Action()
			{
				
				@Override
				public void act() 
				{
					if (input)
						{
							Thread light  = new Thread(new Runnable() 
							{						
								@Override
								public void run() 
								{
									button.highlight();
									input = false;
									try
									{
										Thread.sleep(800);
									}
									catch(InterruptedException e ) 
									{
										e.printStackTrace();
									}
									input = true;
									button.dim();
								}
							});
							light.start();
							if(button == move.get(sequence).getButton())
							{ 
								sequence++;
							} 
							else
							{
								
								progress.gameOver();
								input = false;
							}
							if(sequence == move.size())
							{ 
							    Thread nextRound = new Thread(SimonScreenDaniel.this); 
							    nextRound.start(); 
							}
						}					
					}
				});
		}
		
		progress = getProgress();
		progress.setNum(round, win);
		move.add(getRandomMove());
		move.add(getRandomMove());

		for (int i = 0; i < buttons.length; i++) 
		{
			System.out.println(buttons[i]);
			viewObjects.add(buttons[i]);
		}
		viewObjects.add(progress);
	}

	private MoveInterfaceDaniel getRandomMove() 
	{
		int rnd = (int)(Math.random()*buttons.length);
		while (rnd == previous)
		{
			rnd = (int)(Math.random()*buttons.length);
		}
		return new MoveDaniel(buttons[rnd]);
	}


	private ProgressInterfaceDaniel getProgress() 
	{
		return new ProgressDaniel();
	}

	


	private ButtonInterfaceDaniel getButton(int x,int y,int w, int h) 
	{
		ButtonDaniel button = new ButtonDaniel(x,y,w,h,"",null);
		return button;
	}



}
