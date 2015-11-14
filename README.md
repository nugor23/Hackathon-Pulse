# Hackathon-Pulse
import objectdraw.*;
import java.awt.*;

public class Pulse extends WindowController {
	private static final double BALL_SIZE = 11;
	private ResizablePulse ball;
	private Drawable2DInterface itemShape;
	private Text dateText;

	private static final int MINS_PER_HOUR = 60;
	// Number of hours in one rotation of hour hand of a clock private
	static final int HOURS_PER_ROTATION = 12;
	// Number of seconds in a minute
	private static final int SECS_PER_MIN = 60;

	// Number of milliseconds in a second
	private static final int MILLIS_PER_SEC = 1000;
	// Number of milliseconds in a minute
	private static final int MILLIS_PER_MIN = MILLIS_PER_SEC * SECS_PER_MIN;

	// Number of hours to adjust for local time zone private static final
	int TIMEZONE = -4;

	public void begin() {
		long minutes = System.currentTimeMillis() / MILLIS_PER_MIN;
		long hours = minutes / MINS_PER_HOUR;

		dateText = new Text("The time is now " + minutes % MINS_PER_HOUR + " minutes after "
				+ (hours % HOURS_PER_ROTATION + TIMEZONE), canvas.getWidth()/2, canvas.getHeight()/2, canvas);
	}

	// Create ResizableBall centered at point
	public void onMouseClick(Location point) {
		ball = new ResizablePulse(point.getX(), point.getY(), BALL_SIZE, canvas);
	}

	// public void
	// if(ball.overlaps)
	//
	// {
	// // play sound
	// }
	// }
}
