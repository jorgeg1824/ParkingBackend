package co.edu.uco.parking.crosscuting.exception;

import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.crosscuting.helper.TextHelper;
import co.edu.uco.parking.crosscuting.messagescatalog.MessagesEnum;

public final class ParkingException extends RuntimeException {

	private static final long serialVersionUID = -433023700129543247L;
	private Throwable rootException;
	private String userMessage;
	private String technicalMessage;
	
	private ParkingException(final Throwable rootException, final String userMessage, final String technicalMessage) {
		setRootException(rootException);
		setUserMessage(userMessage);
		setTechnicalMessage(technicalMessage);
	}
	
	public static ParkingException create(final String userMessage) {
		return new ParkingException(new Exception(), userMessage, userMessage);
	}
	
	public static ParkingException create(final String userMessage, final String technicalMessage) {
		return new ParkingException(new Exception(), userMessage, technicalMessage);
	}
	
	public static ParkingException create(final Throwable rootException, final String userMessage, final String technicalMessage) {
		return new ParkingException(rootException, userMessage, technicalMessage);
	}
	
	public static ParkingException createDaoException(final Exception e, final MessagesEnum userMsg, final MessagesEnum techMsg) {
		return ParkingException.create(e, userMsg.getContent(), techMsg.getContent());
	}

	public Throwable getRootException() {
		return rootException;
	}

	public void setRootException(Throwable rootException) {
		this.rootException = ObjectHelper.getDefault(rootException, new Exception());
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = TextHelper.getDefaultWithTrim(userMessage);
	}

	public String getTechnicalMessage() {
		return technicalMessage;
	}

	public void setTechnicalMessage(String technicalMessage) {
		this.technicalMessage = TextHelper.getDefaultWithTrim(technicalMessage);
	}

}
