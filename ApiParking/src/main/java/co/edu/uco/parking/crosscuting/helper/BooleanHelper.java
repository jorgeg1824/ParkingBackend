package co.edu.uco.parking.crosscuting.helper;

public final class BooleanHelper {
	
	private BooleanHelper() {
	}
	
	public static final boolean getDefault() {
		return false;
	}
	
	public static final boolean getDefault(final Boolean value) {
		return ObjectHelper.getDefault(value, getDefault());
	}

}
