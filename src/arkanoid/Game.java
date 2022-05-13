package arkanoid;

import java.awt.Color;
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
	private Menu menu = new Menu();
	private PauseMenu pause = new PauseMenu();
	static int score = 0;
	double BallSpeed = 1;
	double RacquetSpeed = 2;
	public static int WIDTH = 1536;
	public static int HEIGHT = 864;
	static boolean bucle = true;
	public static STATE State = STATE.MENU;
	

	static ArrayList<Brick> Bricks = new ArrayList<>();
	
	DecimalFormat form = new DecimalFormat("#,#");
	
	@SuppressWarnings("unused")
	private double RacquetSpeed() {
		return Double.valueOf(form.format(RacquetSpeed));
	}	
	
	@SuppressWarnings("unused")
	private double BallSpeed() {
		return Double.valueOf(form.format(BallSpeed));
	}

	public Game() {
		
		this.addMouseListener(new MouseInput());
		
		generateBricks(Bricks);
		
		setBackground(Color.BLACK);
		
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(State == STATE.GAME && e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					State = STATE.PAUSE;
				}
				
				else if (State == STATE.PAUSE && e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					State = STATE.GAME;
					Sound.MAIN.loop();
				}
				racquet.keyReleased(e);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);
			}
			
		});
		setFocusable(true);
		
	}
	
	public int PlayerHP() {
		return racquet.playerHp;
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
	
	private void move() throws InterruptedException {
		if(State == STATE.GAME) {
			ball.move();
			racquet.move();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		if(State == STATE.GAME) {
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
			g2d.drawString("HP: " + String.valueOf(PlayerHP()), 430, 530);
		}
		
		else if (State == STATE.MENU) {
			menu.render(g);
		}
		
		else if (State == STATE.PAUSE) {
			pause.render(g);
			Sound.MAIN.stop();
		}
			
	}
	
	public void generateBricks(ArrayList<Brick> Bricks) {
		
		int posX = 15;
		int posY = 10;
		int percent;
		
		for (int i = 0; i < 48; i++) {
			
			Brick brick = null;
			
			percent = (int) (Math.random()*100);
			
			if(percent >= 80) {
				brick = new GreenBrick(posX, posY, this);
			}
			
			else if ((percent < 80) && (percent >= 50)) {
				brick = new BlueBrick(posX, posY, this);
			}
			
			else if ((percent < 50) && (percent >= 30)) {
				brick = new RedBrick(posX, posY, this);
			}
			
			else if ((percent < 30) && (percent >= 10)) {
				brick = new YellowBrick(posX, posY, this);
			}
			
			else if(percent < 10) {
				brick = new SilverBrick(posX, posY, this);
			}
			
			Bricks.add(brick);
			posX += (Brick.getWidth() + 10);
			
			if((i + 2)%8 == 1) {
				posX = 15;
				posY += (Brick.getHeight() + 10);
			}
		}
	}
	
	public void gameOver() {
		
		if(racquet.playerHp == 2 || racquet.playerHp == 1) {
			racquet.x = 200;
			racquet.xa = 0;
			racquet.Y = 520;
			
			ball.x = 200;
			ball.y = 400;
			ball.xa = 1;
			ball.ya = -1;
		}
		
		else if (racquet.playerHp <= 0) {
			
			Sound.MAIN.stop();
			Sound.GAMEOVER.play();
			JOptionPane.showMessageDialog(this, "Your score is:  " + Score(), "Game Over", JOptionPane.YES_NO_OPTION);
			System.exit(ABORT);
		}
	}		
	
	public static enum STATE {
		
		MENU,
		GAME,
		PAUSE
	}
	
	public static void main(String[] args) throws InterruptedException {

		JFrame frame = new JFrame("Arkanoid");
		Game game = new Game();
		frame.add(game);
		frame.setBounds(WIDTH/2 - WIDTH/3/2, HEIGHT/2 - HEIGHT/3, WIDTH/3, (int) (HEIGHT/1.5));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			game.move();
			game.repaint();
			Thread.sleep(8);		
		}	
	}
}
