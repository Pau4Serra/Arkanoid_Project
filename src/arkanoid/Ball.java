package arkanoid;

import java.awt.Graphics2D;
import java.math.*;
import java.awt.Rectangle;

public class Ball {
	private static final int DIAMETER = 30;
	double x = (Math.random()*580 + 20);
	double y = (Math.random()*25 + 5);
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
		
		else if (collisionRacquet()) {
			ya = -game.speed;
			y = game.racquet.getTopY() - (DIAMETER-5); //sus
			game.speed += 0.1;
			game.score++;	
		} 
		
		/*
		 * else if (collisionBrickTopY()) { ya = -game.speed; y = game.brick.getTopY() -
		 * (DIAMETER-25); //game.brick.hp--; if (game.brick.hp == 0) { game.brick =
		 * null; System.gc(); } }
		 */
		
		else if ((x + DIAMETER + xa > game.brick.x) 
				&& (x + xa < game.brick.x + Brick.WIDTH) 
				&& (y + DIAMETER > game.brick.y) 
				&& (y < game.brick.y + Brick.HEIGHT)) {
			
			xa *= -1;
		}
		
		else if ((x + DIAMETER > game.brick.x) 
				&& (x < game.brick.x + Brick.WIDTH) 
				&& (y + DIAMETER + ya > game.brick.y) 
				&& (y + ya < game.brick.y + Brick.HEIGHT)) {
			
			ya *= -1;
		}
		else {
			changeDirection = false;
		}
		
		if (changeDirection) {
			Sound.BALL.play();
		}
		
		x = x + xa;
		y = y + ya;
	}
	
	private boolean collisionRacquet() {
		return game.racquet.getBounds().intersects(getBounds());
	}
	
	/*
	 * private boolean collisionBrickTopY() { return
	 * game.brick.getBounds().intersects(getBounds()); }
	 */

	public void paint(Graphics2D g) {
		g.fillOval((int) x, (int) y, DIAMETER, DIAMETER);
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int )x, (int) y, DIAMETER, DIAMETER);
	}

}
