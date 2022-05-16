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
		if (Game.Bricks.get(i).Alive == false) {
			if(i + 1 < game.Bricks.size()) {
				game.Bricks.remove(i + 1);
				game.Bricks.get(i + 1).Alive = false;
			}
			
			if(i - 1 > game.Bricks.size()) {
				game.Bricks.remove(i - 1);
				game.Bricks.get(i - 1).Alive = false;
			}
		}		
	}

	@Override
	public void brickDie(int i) {
		// TODO Auto-generated method stub
		hp--;
		if (hp == 0) {
			Alive = false;
			Game.Bricks.get(i).action(i);
			Game.Bricks.remove(i);
			Game.score += 5;
		}	
	}

}
