package co.edu.uco.parking.crosscuting.helper;

import java.time.Duration;

public final class DurationHelper {
	
	public static final Duration DEFAULT_DURATION = Duration.ZERO;
	
	private DurationHelper() {
	}
	
	public static Duration getDefault() {
		return DEFAULT_DURATION;
	}
	
	public static Duration getDefault(final Duration value) {
		return ObjectHelper.getDefault(value, getDefault());
	}
	
	public static long toMinutes(final Duration duration) {
		return getDefault(duration).toMinutes();
	}
	
	public static double toHours(final Duration duration) {
		return getDefault(duration).toMinutes() / 60.0;
	}

}
