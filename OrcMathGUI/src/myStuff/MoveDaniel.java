package myStuff;

public class MoveDaniel implements MoveInterfaceDaniel
{

	private ButtonDaniel a;
	private SimonScreenDaniel d;
	
	public MoveDaniel(ButtonDaniel b) 
	{
		this.a = b;
	}

	@Override
	public MoveInterfaceDaniel getMove(int bIndex) 
	{
		return d.move.get(bIndex);
	}

	@Override
	public ButtonInterfaceDaniel getButton() 
	{
		return a;
	}

}
