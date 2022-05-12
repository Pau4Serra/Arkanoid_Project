package arkanoid;

import java.awt.Color;
import java.awt.Graphics2D;
import java.math.*;
import java.awt.Rectangle;

public class Ball {
	private static final int DIAMETER = 20;
	double x = 200;
	double y = 400;
	double xa = 1;
	double ya = -1;
	Game game;
	static boolean col;
	
	public Ball(Game game) {
		this.game = game;
	}
	
	void move() {
		col = false;
		boolean changeDirection = true;
		
		for(int i = 0; i < game.Bricks.size(); i++) {
		
			Game.Bricks.get(i).action(i);
			
			if (x + xa < 0) {
				xa = game.BallSpeed;
			} 
			 
			else if (x + xa > game.getWidth() - DIAMETER) {
				xa = -game.BallSpeed;
			}
			
			else if (y + ya < 0) {
				ya = game.BallSpeed;
			} 
			 
			else if (y + ya > game.getHeight() - DIAMETER) {
				game.racquet.playerHp--;
				game.PlayerHP();
				game.paint(game.getGraphics());
				game.gameOver();
			}
			
			else if (collisionRacquet()) {
				ya = -game.BallSpeed;
				y = game.racquet.getTopY() - (DIAMETER-5);
				if(game.BallSpeed < 4) {
					game.RacquetSpeed += 0.1;
					game.BallSpeed += 0.1;
				}
			} 
			
			else if ((x + DIAMETER + xa > game.Bricks.get(i).x) 
					&& (x + xa < game.Bricks.get(i).x + Brick.WIDTH) 
					&& (y + DIAMETER > game.Bricks.get(i).y) 
					&& (y < game.Bricks.get(i).y + Brick.HEIGHT) && (Game.Bricks.get(i).Alive)) {
				
						col = true;
						xa *= -1;
						Game.Bricks.get(i).brickDie(i);
			}
			
			else if ((x + DIAMETER > game.Bricks.get(i).x) 
					&& (x < game.Bricks.get(i).x + Brick.WIDTH) 
					&& (y + DIAMETER + ya > game.Bricks.get(i).y) 
				    && (y + ya < game.Bricks.get(i).y + Brick.HEIGHT) && (Game.Bricks.get(i).Alive)) {
				
						col = true;
						ya *= -1;
						Game.Bricks.get(i).brickDie(i);
			}
			
			else {
				changeDirection = false;
			}
			
			if (changeDirection) {
				Sound.BALL.play();
				}
		}
		
		for (int i = 0; i < game.Bricks.size(); i++) {
			if(game.racquet.getBounds().intersects(game.Bricks.get(i).getBounds())) {
				game.racquet.playerHp = 0;
				game.PlayerHP();
				game.paint(game.getGraphics());
				game.gameOver();
			}
		}
			x = x + xa;
			y = y + ya;

		}
	
	public boolean isCol() {
		return col;
	}

	public void setCol(boolean col) {
		this.col = col;
	}

	private boolean collisionRacquet() {
		return game.racquet.getBounds().intersects(getBounds());
	}

	public void paint(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillOval((int) x, (int) y, DIAMETER, DIAMETER);
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int )x, (int) y, DIAMETER, DIAMETER);
	}

}
