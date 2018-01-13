package assessment;

import guiTeacher.GUIApplication;

public class mainGUI extends GUIApplication {

	public static Screen a;
	public mainGUI(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {

		a = new Screen(getWidth(), getHeight());
		setScreen(a);
	}
	
	public static void main(String[] args)
	{
		mainGUI gui = new mainGUI(500,500);
		Thread runner = new Thread(gui);
		runner.start();
	}

}
