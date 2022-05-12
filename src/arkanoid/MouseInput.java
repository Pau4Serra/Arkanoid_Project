package arkanoid;

import java.awt.Rectangle;
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
		
		//Play button on menu
		if(Game.State == Game.STATE.MENU) {
			if((mx >= 200) && (mx <= 300)) {
				if((my >= 120) && (my <= 170)) {
					Game.State = Game.STATE.GAME;
					Sound.MAIN.loop(); 
				}
			}
		}
		
		//Rules button on menu
		if(Game.State == Game.STATE.MENU) {
			if((mx >= 200) && (mx <= 300)) {
				if((my >= 220) && (my <= 270)) {
					Game.State = Game.STATE.RULES;
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
