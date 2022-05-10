package arkanoid;

import java.awt.Graphics2D;
import java.awt.Color;

public class GreenBrick extends Brick{


	public GreenBrick(int x, int y, Game game) {
		super(x, y, 3, game, true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.GREEN);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}

	public void action(int i) {
		
	}

	@Override
	public void brickDie(int i) {
		hp--;
		if (hp == 0) {
			Game.Bricks.remove(i);
			Game.score++;
		}
	}
}
