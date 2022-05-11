package arkanoid;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public abstract class Brick {
	
	public static final int WIDTH = 50;
	public static final int HEIGHT = 20;
	int x;
	int y;
	int hp = 1;
	boolean Alive = true;
	
	protected static Game game;
	
	public Brick(int x, int y, int hp, Game game, boolean Alive) {
		this.x = x;
		this.y = y;
		this.hp = hp;
		this.game = game;
		this.Alive = Alive;
		
	}
	
	public abstract void paint(Graphics2D g);
	public abstract void action(int i);
	public abstract void brickDie(int i);
	
	public static void generateBricks(ArrayList<Brick> Bricks, Brick brick) {
		
		int posX = 15;
		int posY = 10;
		int percent;
		
		for (int i = 0; i < 48; i++) {
			
			percent = (int) (Math.random()*100);
			
			if(percent >= 80) {
				brick = new GreenBrick(posX, posY, game);
			}
			
			else if ((percent < 80) && (percent >= 50)) {
				brick = new BlueBrick(posX, posY, game);
			}
			
			else if ((percent < 50) && (percent >= 30)) {
				brick = new RedBrick(posX, posY, game);
			}
			
			else if ((percent < 30) && (percent >= 10)) {
				brick = new YellowBrick(posX, posY, game);
			}
			
			else if(percent < 10) {
				brick = new SilverBrick(posX, posY, game);
			}
			
			Bricks.add(brick);
			posX += (WIDTH + 10);
			
			if((i + 2)%8 == 1) {
				posX = 15;
				posY += (HEIGHT + 10);
			}
		}
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
}
