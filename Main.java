import javax.swing.JFrame;

class Main{

	public static void main(String args[])
	{	
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // to be able to close the window
		window.setResizable(false); // so the window can not be resized
		window.setTitle("Freeway"); // set a title to the window
		
		
		GamePanel gamePanel = new GamePanel(); // create a panel
		window.add(gamePanel); // add the game panel to this window
		window.pack(); // make the window to be sized to fit the panel
		
		window.setLocationRelativeTo(null); // to position the window on the center of the screen
		window.setVisible(true); // to show the window
		
		
	
	}

}
