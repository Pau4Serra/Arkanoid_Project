package arkanoid;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Racquet {
	private static final int Y = 330;
	private static final int WIDTH = 60;
	private static final int HEIGHT = 10;
	double x = 120;
	double xa = 0;
	private Game game;
	
	public Racquet(Game game) {
		this.game = game;
	}
	
	public void move() {
		if (x + xa > 0 && x + xa < game.getWidth() - 60) {
			x = x + xa;
		}
	}
	
	public void paint(Graphics2D g) {
		g.fillRect((int) x, Y, WIDTH, HEIGHT);
	}
	
	public void keyReleased(KeyEvent e) {
		xa = 0; //sus
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			xa = -game.speed;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			xa = game.speed;
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int) x, Y, WIDTH, HEIGHT);
	}
	
	public int getTopY() {
		return Y - HEIGHT;
	}
}
