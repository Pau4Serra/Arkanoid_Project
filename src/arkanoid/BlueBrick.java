package arkanoid;

import java.awt.Graphics2D;
import java.awt.Color;

public class BlueBrick extends Brick{


	public BlueBrick(int x, int y, Game game) {
		super(x, y, 1, game, true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLUE);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}
	
	@Override
	public void action(int i) {
		
	}

	@Override
	public void brickDie(int i) {
		hp--;
		if (hp == 0) {
			Alive = false;
			Game.Bricks.remove(i);
			Game.score++;
		}		
	}
}
