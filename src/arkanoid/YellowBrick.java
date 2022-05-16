package arkanoid;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Timer;
import java.util.TimerTask;

public class YellowBrick extends Brick{

	public YellowBrick(int x, int y, Game game) {
		super(x, y, 1, game, true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}

	@Override
	public void action(int i) {
			
	}

	@Override
	public void brickDie(int i) {
		// TODO Auto-generated method stub
		hp--;
		if (hp == 0) {
			Alive = false;
			Game.Bricks.remove(i);
			Game.score++;
		}	
	}
}
