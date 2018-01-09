package myStuff;

public class MoveDaniel implements MoveInterfaceDaniel
{

	private ButtonInterfaceDaniel button;
	

	public MoveDaniel(ButtonInterfaceDaniel button) {
		this.button = button;
	}
	public ButtonInterfaceDaniel getButton()
	{
		return button;
	}


}
