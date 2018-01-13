package assessment;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.Timer;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class Screen extends FullFunctionScreen {

	private int score;
	private Button click;
	private TextLabel scoreText;
	private TextLabel countdown;
	private boolean isClicked;
	private int clicked;
	private boolean secondClick;
	/*
	private TextLabel countdown1;
	private TextLabel countdown2;
	private TextLabel countdown3;
	private TextLabel countdown4;
	*/
	public Screen(int width, int height) {
		super(width, height);
		score = 0;
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects)
	{
		clicked = 0;     
		String text = "Score:"+score;
		scoreText = new TextLabel(100,100,100,100,text);
		viewObjects.add(scoreText);
		
		countdown = new TextLabel(100,160,240,270,"");
		viewObjects.add(countdown);
		/*
		countdown2 = new TextLabel(100,170,240,270,"2");
		viewObjects.add(countdown2);
		countdown3 = new TextLabel(100,180,240,270,"1");
		viewObjects.add(countdown3);
		countdown4 = new TextLabel(100,190,240,270,"Go!");
		viewObjects.add(countdown4);
		*/
		click = new Button(100,250,250,250,"Ready",new Action()
		{
			
			@Override
			public void act()
			{	
				if (!isClicked)
				{
					new Thread()
					{
					     public void run() 
					     {							   
							   try 
							   {
								   countdown.setText("3");
								   countdown.update();
								   Thread.sleep(1000);
								   countdown.setText("2");
								   countdown.update();
								   Thread.sleep(1000);
								   countdown.setText("1");
								   countdown.update();
								   Thread.sleep(1000);
								   countdown.setText("Go!");
								   countdown.update();
								   click.setText("Click me!");								  
							   }
							   catch (InterruptedException e) 
							   {
								   e.printStackTrace();
							   }


					     }
					  } 
					  .start();					 
					  isClicked = true;
				}
				else
				{
					if (!secondClick)
					{
						new Thread()
						{
						     public void run() 
						     {							   
								   try 
								   {
									   secondClick = true;
									   countdown.setText("5 Seconds Left");
									   countdown.update();
									   Thread.sleep(1000);
									   countdown.setText("4 Seconds Left");
									   countdown.update();
									   Thread.sleep(1000);
									   countdown.setText("3 Seconds Left");
									   countdown.update();
									   Thread.sleep(1000);
									   countdown.setText("2 Seconds Left");
									   countdown.update();
									   Thread.sleep(1000);
									   countdown.setText("1 Second Left");
									   countdown.update();
									   Thread.sleep(1000);
									   countdown.setText("Time's Up!");
									   countdown.update();
									   
								   }
								   catch (InterruptedException e) 
								   {
									   e.printStackTrace();
								   }
	
	
						     }
						  } 
						  .start();	
					}
					else
					{
						if (!countdown.getText().equals("Time's Up!"))
						{
							clicked++;
							scoreText.setText(""+clicked);
						}
					}
					 
				}
				
				
		
			}
		});
		
		viewObjects.add(click);
	}
	
}
