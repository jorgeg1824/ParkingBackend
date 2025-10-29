package co.edu.uco.parking.crosscuting.helper;

public final class NumericHelper {
	
	private static final int DEFAULT = 0;
	
	private NumericHelper() {
	}
	
	public static int getDefault() {
		return DEFAULT;
	}
	
	public static int getDefault(final Integer value) {
		return ObjectHelper.getDefault(value, getDefault());
	}
	
	public static boolean isGreaterThanZero(final Integer value) {
        return getDefault(value) > 0;
    }

    public static boolean isLessThanZero(final Integer value) {
        return getDefault(value) < 0;
    }

    public static boolean isZero(final Integer value) {
        return getDefault(value) == 0;
    }

    public static boolean isPositive(final Integer value) {
        return isGreaterThanZero(value);
    }

    public static boolean isNegative(final Integer value) {
        return isLessThanZero(value);
    }
	
}
