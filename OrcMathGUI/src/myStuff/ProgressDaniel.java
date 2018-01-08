package myStuff;

import java.awt.image.BufferedImage;

public class ProgressDaniel implements ProgressInterfaceDaniel
{

	private SimonScreenDaniel a;
	
	public ProgressDaniel() 
	{
		
	}

	@Override
	public BufferedImage getImage() 
	{
		return null;
	}

	@Override
	public int getX() 
	{
		return a.getX();
	}

	@Override
	public int getY() 
	{
		return a.getY();
	}

	@Override
	public void setX(int x) 
	{
		x = a.getX();
	}

	@Override
	public void setY(int y) 
	{
		y = a.getY();
	}

	@Override
	public int getWidth() 
	{
		return a.getWidth();
	}

	@Override
	public int getHeight()
	{
		return a.getHeight();
	}

	@Override
	public void update() 
	{
		
	}

	@Override
	public boolean isAnimated() 
	{
		return false;
	}

	@Override
	public void setVisible(boolean b) 
	{

	}

	@Override
	public boolean isVisible() 
	{
		return false;
	}

	@Override
	public float getAlpha() 
	{
		return 0;
	}

	@Override
	public void setAlpha(float f) 
	{
		
	}

	@Override
	public void unhoverAction() 
	{
		
	}

	@Override
	public void hoverAction()
	{
		
	}

	@Override
	public void gameOver() 
	{
		
	}

	@Override
	public void setRound(int round)
	{
		
	}

	@Override
	public void setSequenceSize(int size)
	{
		
	}

}
