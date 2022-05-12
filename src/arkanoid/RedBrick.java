package arkanoid;

import java.awt.Graphics2D;
import java.awt.Color;

public class RedBrick extends Brick{

	public RedBrick(int x, int y, Game game) {
		super(x, y, 2, game, true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.RED);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}
	
	@Override
	public void action(int i) {
		
		if (Game.Bricks.get(i).Alive == false) {
			Game.Bricks.get(i).y += 3;
			
	
		}
	}

	@Override
	public void brickDie(int i) {
		hp--;
		if (hp == 0) {
			Alive = false;
			Game.Bricks.get(i).action(i);;
			Game.score += 2;
		}
	}
}
