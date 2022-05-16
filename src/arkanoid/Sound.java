package arkanoid;

import java.applet.Applet;
import java.applet.AudioClip;


public class Sound {
	public static final AudioClip MAIN = Applet.newAudioClip(Sound.class.getResource("provafons.wav"));
	public static final AudioClip BALL = Applet.newAudioClip(Sound.class.getResource("8bitbounce.wav"));
	public static final AudioClip GAMEOVER = Applet.newAudioClip(Sound.class.getResource("gameover.wav"));
	public static final AudioClip WIN = Applet.newAudioClip(Sound.class.getResource("WIN.wav"));
	public static final AudioClip MENU = Applet.newAudioClip(Sound.class.getResource("mainMenu.wav"));
	

}

