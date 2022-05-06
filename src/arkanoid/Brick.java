package arkanoid;

import java.awt.Color;
import java.text.DecimalFormat;
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

public class Brick {
	
	public static final int WIDTH = 100;
	public static final int HEIGHT = 30;
	
	int x = 265;
	int y = 250;
	int hp = 1;
	
	private Game game;
	
	public Brick(Game game) {
		this.game = game;
	}

	public void paint(Graphics2D g) {
		g.fillRect(x, y, WIDTH, HEIGHT);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
	
	/*
	 * public int getTopY() { return y - HEIGHT; }
	 * 
	 * public int getBotY() { return y + HEIGHT; }
	 * 
	 * public int rightX() { return x + WIDTH; }
	 * 
	 * public int leftX() { return x - WIDTH; }
	 */
}
