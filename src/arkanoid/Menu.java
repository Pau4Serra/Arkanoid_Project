package arkanoid;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;

public class Menu {
	
	public Rectangle play = new Rectangle(200, 120, 100, 50);
	public Rectangle howToPlay = new Rectangle(200, 220, 100, 50);
	public Rectangle exit = new Rectangle(200, 320, 100, 50);
	
	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		
		
		Font font = new Font("Verdana", Font.BOLD, 50);
		g.setFont(font);
		g.setColor(Color.BLACK);
		g.drawString("ARKANOID", 90, 60);
		
		Font font1 = new Font("Arial", Font.BOLD, 30);
		g.setFont(font1);
		g.setColor(Color.BLACK);
		g.drawString("Play", play.x + 19, play.y + 35);
		g2d.draw(play);
		g.drawString("Rules", howToPlay.x + 10, howToPlay.y + 35);
		g2d.draw(howToPlay);
		g.drawString("Quit", exit.x + 19, exit.y + 35);
		g2d.draw(exit);
	}
}
