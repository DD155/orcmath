package myStuff;

import java.util.ArrayList;
import java.awt.Color;
import java.util.List;



import guiTeacher.components.Action;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenDaniel extends ClickableScreen implements Runnable 
{

	private static final long serialVersionUID = 2507116048493230544L;
	
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
		move.add(randomMove());
		
		label.setText("Follow Me.");
		
		input();
		
		label.setText("Repeat.");
		sequence = 0;
		input = true;
		
	}
	
	public void input()
	{
		ButtonInterfaceDaniel b;
		for(int i = 0; i < move.size(); i++) 
		{
			b = move.get(i).getButton();
			b.highlight();
			try 
			{
				Thread.sleep((int)(800 * round));
			} 
			catch (InterruptedException e) 
			{
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
		
		
		label = new TextLabel(70,250,150,100,"Let's Play! Follow Me.");
		viewObjects.add(label);
		
		for (int i = 0; i < buttons.length; i++) 
		{
			
			final ButtonInterfaceDaniel button = getButton(100*i,300,70,70);
			buttons[i] = button;
			button.setColor(colors[i]);
			button.setAction(new Action()
			{
				
				@Override
				public void act() 
				{
					if (input)
					{
						Thread follow  = new Thread(new Runnable() 
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
								catch(InterruptedException e) 
								{
									e.printStackTrace();
								}
								input = true;
								button.dim();
							}
						});
						follow.start();
						if (button == move.get(sequence).getButton())
						{ 
							sequence++;
						} 
						else
						{							
							progress.gameOver();
							input = false;
						}
						if (sequence == move.size())
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
		move.add(randomMove());
		move.add(randomMove());

		for (int i = 0; i < buttons.length; i++) 
		{
			System.out.println(buttons[i]);
			viewObjects.add(buttons[i]);
		}
		viewObjects.add(progress);
	}

	private MoveInterfaceDaniel randomMove() 
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
		ButtonDaniel button = new ButtonDaniel(x, y, w, h, "", null);
		return button;
	}



}
