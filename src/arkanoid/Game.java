package arkanoid;

import java.awt.Color;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Game extends JPanel {
	
	Ball ball = new Ball(this);
	Racquet racquet = new Racquet(this);
	static Brick brick;
	static int score = 0;
	double BallSpeed = 1;
	double RaquetSpeed = 2;
	public static int WIDTH = 1536;
	public static int HEIGHT = 864;

	static ArrayList<Brick> Bricks = new ArrayList<>();
	
	DecimalFormat form = new DecimalFormat("#,#");
	
	@SuppressWarnings("unused")
	private double RacquetSpeed() {
		return Double.valueOf(form.format(RaquetSpeed));
	}
	
	@SuppressWarnings("unused")
	private double BallSpeed() {
		return Double.valueOf(form.format(BallSpeed));
	}

	public Game() {
		
		setBackground(Color.BLACK);
		
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);
			}
		});
		setFocusable(true);
		Sound.MAIN.loop();
	}
	
	public static int Score() {
		return score;
	}
	
	public static int Width() {
		return WIDTH;
	}

	public static int Height() {
		return HEIGHT;
	}
	
	private void move() {
		ball.move();
		racquet.move();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
		racquet.paint(g2d);
		
		for (int i = 0; i < Bricks.size(); i++) {
			Bricks.get(i).paint(g2d);
		}
		
		g2d.setColor(Color.RED);
		g2d.setFont(new Font("Verdana", Font.BOLD, 20));
		g2d.drawString("Score: " + String.valueOf(Score()), 10, 530);
		
	}
	
	public void gameOver() {
		Sound.MAIN.stop();
		Sound.GAMEOVER.play();
		JOptionPane.showMessageDialog(this, "Your score is:  " + Score(), "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}		

	public static void main(String[] args) throws InterruptedException {

		Brick.generateBricks(Bricks, brick);
		JFrame frame = new JFrame("Arkanoid");
		Game game = new Game();
		frame.add(game);
		frame.setBounds(WIDTH/2 - WIDTH/3/2, HEIGHT/2 - HEIGHT/3, WIDTH/3, (int) (HEIGHT/1.5));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			game.move();
			game.repaint();
			Thread.sleep(8);
			
		}
	}
	
}
