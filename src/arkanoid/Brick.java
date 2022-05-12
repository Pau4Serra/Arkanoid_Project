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
	public int x;
	public int y;
	public int hp;
	public boolean Alive = true;
	
	public static int getWidth() {
		return WIDTH;
	}

	public static int getHeight() {
		return HEIGHT;
	}



	protected Game game;
	
	public Brick(int x, int y, int hp, Game game, boolean Alive) {
		this.x = x;
		this.y = y;
		this.hp = hp;
		this.Alive = Alive;
		this.game = game;
		
	}
	
	public abstract void paint(Graphics2D g);
	public abstract void action(int i);
	public abstract void brickDie(int i);
	
	
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
}
