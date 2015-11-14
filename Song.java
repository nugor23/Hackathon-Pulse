import java.applet.AudioClip;
import objectdraw.*;

public class Song extends Controller {

	// The interval at which the pitches of the circles decrease.
	private static final double SIZE_DIFF = 50.0;

	// The average size of the touching pulses.
	private double AVG_SIZE;

	// The pitch that should play.
	private int NOTE;

	// The name of the file associated with the sound.
	private String fileName;

	// The sound which plays.
	private AudioClip tone;

	// Chooses what sound to play on the basis of the average size of the pulses
	// and the color of the first pulse.
	public Song(ResizablePulse one, ResizablePulse two) {
		AVG_SIZE = (one.getSize() + two.getSize()) / 2;
		NOTE = 0;
		if (one.getHue() == 1) {
			fileName = new String("Cello");
		} else if (one.getHue() == 2) {
			fileName = new String("Clarinet");
		} else if (one.getHue() == 3) {
			fileName = new String("French");
		} else if (one.getHue() == 4) {
			fileName = new String("Guitar");
		} else if (one.getHue() == 5) {
			fileName = new String("Tuba");
		} else {
			fileName = new String("Xylo");
		}
		for (double n = 8.0; n > 0.0; n--) {
			if (AVG_SIZE < n * SIZE_DIFF) {
				NOTE = NOTE + 1;
			}
		}
		fileName = new String(fileName + NOTE);
		tone = getAudio(fileName);
	}

	// Plays the sound.
	public void playMusic() {
		tone.play();
	}
}
