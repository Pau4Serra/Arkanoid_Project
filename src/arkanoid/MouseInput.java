package arkanoid;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener{
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	
		int mx = e.getX();
		int my = e.getY();
		
		//Play button
		if((mx >= 200) && (mx <= 300)) {
			if((my >= 120) && (my <= 170)) {
				Game.State = Game.STATE.GAME;
			}
		}
		
		//Rules button
		if((mx >= 200) && (mx <= 300)) {
			if((my >= 220) && (my <= 270)) {
				Game.State = Game.STATE.RULES;
			}
		}
		
		//Exit button
		if((mx >= 200) && (mx <= 300)) {
			if((my >= 320) && (my <= 370)) {
				System.exit(0);
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
