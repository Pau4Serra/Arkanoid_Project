package arkanoid;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Racquet {
	
	
	private static final int WIDTH = 80;
	private static final int HEIGHT = 10;
	double x = 200;
	double xa = 0;
	Game game;
	public Racquet(Game game) {;
		this.game = game;
	}
	
	public void move() {
		if (x + xa > 0 && x + xa < game.getWidth() - 80) {
			x = x + xa;
			
		}
	}
	
	public void paint(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillRect((int) x, Y, WIDTH, HEIGHT);
	}
	
	public void keyReleased(KeyEvent e) {
		xa = 0; //sus
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			xa = -game.RacquetSpeed;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			xa = game.RacquetSpeed;
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int) x, Y, WIDTH, HEIGHT);
	}
	
	public int getTopY() {
		return Y - HEIGHT;
	}
	
	int Y = 520;
}
