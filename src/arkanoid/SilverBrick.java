package arkanoid;

import java.awt.Color;
import java.awt.Graphics2D;

public class SilverBrick extends Brick{

	public SilverBrick(int x, int y, Game game) {
		super(x, y, 5, game, true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.WHITE);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}

	@Override
	public void action(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void brickDie(int i) {
		// TODO Auto-generated method stub
		hp--;
		if (hp == 0) {
			Alive = false;
			Game.Bricks.remove(i);
			Game.score += 5;
		}	
	}

}
