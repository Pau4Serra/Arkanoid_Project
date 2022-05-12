package arkanoid;

import javax.swing.JOptionPane;

public class Rules {
	
	public static void rules() {
		
		JOptionPane.showMessageDialog(null, "Rules: \n\nRed Brick: 2 HP, drops when destroyed, if it falls above the racquet, you lose (2 points). "
				+ "\nBlue Brick: 1 HP, generic brick (1 point). \nGreen Brick: 3 HP, generic brick, but a bit tough (3 points). \nYellow Brick: Not implemented yet."
				+ "\nSilver Brick: Not implemented yet.");
	}
}
