package co.edu.uco.parking.crosscuting.helper;

import java.time.LocalDateTime;

public final class DateHelper {
	
	private static final LocalDateTime DEFAULT_DATE = LocalDateTime.MIN;
	
	private DateHelper() {
	}
	
	public static LocalDateTime getDefault() {
		return DEFAULT_DATE;
	}
	
	public static LocalDateTime getDefault(final LocalDateTime value) {
		return ObjectHelper.getDefault(value, getDefault());
	}

}
