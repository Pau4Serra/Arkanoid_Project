package arkanoid;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
	private static final int DIAMETER = 30;
	double x = 0;
	double y = 0;
	double xa = 1;
	double ya = 1;
	private Game game;
	
	public Ball(Game game) {
		this.game = game;
	}
	
	void move() {
		boolean changeDirection = true;
		if (x + xa < 0) {
			xa = game.speed;
		} 
		 
		else if (x + xa > game.getWidth() - DIAMETER) {
			xa = -game.speed;
		}
		
		else if (y + ya < 0) {
			ya = game.speed;
		} 
		 
		else if (y + ya > game.getHeight() - DIAMETER) {
			game.gameOver();
		}
		
		else if (collision()) {
			ya = -game.speed;
			y = game.racquet.getTopY() - (DIAMETER-5); //sus
			game.speed += 0.1;
			game.score++;
			
			
		} else {
			changeDirection = false;
		}
		
		if (changeDirection) {
			Sound.BALL.play();
		}
		
		x = x + xa;
		y = y + ya;
	}
	
	private boolean collision() {
		return game.racquet.getBounds().intersects(getBounds());
	}

	public void paint(Graphics2D g) {
		g.fillOval((int) x, (int) y, DIAMETER, DIAMETER);
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int )x, (int) y, DIAMETER, DIAMETER);
	}

}
