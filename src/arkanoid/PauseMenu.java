package arkanoid;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class PauseMenu {

	public Rectangle play = new Rectangle(170, 300, 155, 50);
	public Rectangle exit = new Rectangle(200, 380, 100, 50);
	
	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		Font font = new Font("Verdana", Font.BOLD, 50);
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString("PAUSE MENU", 60, 250);
		
		Font font1 = new Font("Arial", Font.BOLD, 30);
		g.setFont(font1);
		g.setColor(Color.WHITE);
		g.drawString("Resume", play.x + 19, play.y + 35);
		g2d.draw(play);
		g.drawString("Quit", exit.x + 19, exit.y + 35);
		g2d.draw(exit);
	}
	
}
