package myStuff;

public class MoveDaniel implements MoveInterfaceDaniel
{

	private SimonScreenDaniel a;
	
	public MoveDaniel() 
	{
		a.update();
	}

	@Override
	public MoveInterfaceDaniel getMove(int bIndex) 
	{
		return a.move.get(bIndex);
	}

	@Override
	public ButtonInterfaceDaniel getButton() 
	{
		return a.buttons[0];
	}

}
