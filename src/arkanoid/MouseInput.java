package arkanoid;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MouseInput implements MouseListener{
	
	public String playerName = null;
	
	private JFrame f;
	private JPanel p;
	
	public MouseInput(JPanel p, JFrame f) {
		this.f=f;
		this.p = p;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	
		int mx = e.getX();
		int my = e.getY();
		
		//Play button on menu
		if(Game.State == Game.STATE.MENU) {
			if((mx >= 200) && (mx <= 300)) {
				if((my >= 120) && (my <= 170)) {
					
					playerName = JOptionPane.showInputDialog(null);
					f.setExtendedState(Frame.ICONIFIED);
					f.setExtendedState(Frame.NORMAL);
					if(playerName != null && playerName.length() > 0) {
						Game.State = Game.STATE.GAME;
						Sound.MAIN.loop(); 
					} else {
						JOptionPane.showMessageDialog(null, "A name is required in order to play");
						f.setExtendedState(Frame.ICONIFIED);
						f.setExtendedState(Frame.NORMAL);
					}
						
				}
			}
		}
		
		//Rules button on menu
		if(Game.State == Game.STATE.MENU) {
			if((mx >= 200) && (mx <= 300)) {
				if((my >= 220) && (my <= 270)) {
					JOptionPane.showMessageDialog(null, "                                                    -   Welcome to Arkanoid   -\n\nThis game consists in breaking the bricks in order "
							+ "to achieve the high score and be"
							+ "\nable to enter in the TOP SCORES JSON file."
							+ "\n\nRules: \n- You have 3HP, if the ball touches the bottom of the screen you lose one HP. "
							+ "\n- If your HP reaches 0, you lose."
							+ "\n- Bricks description: "
							+ "\n      · Red Brick: 2 HP, drops when destroyed, if it falls above the racquet, you lose (2 points). "
							+ "\n      · Blue Brick: 2HP, when destroyed the racquet moves faster for 10 seconds (2 points). "
							+ "\n      · Green Brick: 3 HP, generic brick, but a bit tough (3 points). "
							+ "\n      · Yellow Brick: 1 HP, generic brick (1 point)."
							+ "\n      · Silver Brick: 5HP, when destroyed it also breaks the bricks it has in both sides (5 points)."
							+ "\n- Have fun!"
							+ "\n\n\n                                         Developed and designed by Pau Serra");
					f.setExtendedState(Frame.ICONIFIED);
					f.setExtendedState(Frame.NORMAL);
					
				}
			}
		}
		
		//Exit button on menu
		if(Game.State == Game.STATE.MENU) {
			if((mx >= 200) && (mx <= 300)) {
				if((my >= 320) && (my <= 370)) {
					System.exit(0);
				}
			}
		}
		
		//Resume button on pause menu
		if(Game.State == Game.STATE.PAUSE) {
			if((mx >= 170) && (mx <= 325)) {
				if((my >= 300) && (my <= 350)) {
					Game.State = Game.STATE.GAME;
					Sound.MAIN.loop();
				}
			}
		}
		
		//Exit button on pause menu
		if(Game.State == Game.STATE.PAUSE) {
			if((mx >= 200) && (mx <= 300)) {
				if((my >= 380) && (my <= 430)) {
					System.exit(0);
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
