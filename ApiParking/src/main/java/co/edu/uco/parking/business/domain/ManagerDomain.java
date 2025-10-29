package co.edu.uco.parking.business.domain;

import java.util.UUID;

import co.edu.uco.parking.crosscuting.helper.BooleanHelper;
import co.edu.uco.parking.crosscuting.helper.TextHelper;
import co.edu.uco.parking.crosscuting.helper.UUIDHelper;

public final class ManagerDomain extends Domain{
	
	private String documentNumber;
	private String name;
	private String firstSurname;
	private String secondSurname;
	private String email;
	private String phoneNumber;
	private boolean emailConfirmed;
	private boolean phoneConfirmed;
	private boolean isActive;
	
	public ManagerDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setDocumentNumber(TextHelper.getDefault());
		setName(TextHelper.getDefault());
		setFirstSurname(TextHelper.getDefault());
		setSecondSurname(TextHelper.getDefault());
		setEmail(TextHelper.getDefault());
		setPhoneNumber(TextHelper.getDefault());
		setEmailConfirmed(BooleanHelper.getDefault());
		setPhoneConfirmed(BooleanHelper.getDefault());
		setActive(BooleanHelper.getDefault());
	}
	
	public ManagerDomain(final UUID id, final String documentNumber, final String name, final String firstSurname,
			final String secondSurname, final String email, final String phoneNumber, final boolean emailConfirmed, final boolean phoneConfirmed,
			final boolean isActive) {
		super(id);
		setDocumentNumber(documentNumber);
		setName(name);
		setFirstSurname(firstSurname);
		setSecondSurname(secondSurname);
		setEmail(email);
		setPhoneNumber(phoneNumber);
		setEmailConfirmed(emailConfirmed);
		setPhoneConfirmed(phoneConfirmed);
		setActive(isActive);
	}

	public String getDocumentNumber() {
		return documentNumber;
	}
	public void setDocumentNumber(final String documentNumber) {
		this.documentNumber = TextHelper.getDefaultWithTrim(documentNumber);
	}
	public String getName() {
		return name;
	}
	public void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}
	public String getFirstSurname() {
		return firstSurname;
	}
	public void setFirstSurname(final String firstSurname) {
		this.firstSurname = TextHelper.getDefaultWithTrim(firstSurname);
	}
	public String getSecondSurname() {
		return secondSurname;
	}
	public void setSecondSurname(final String secondSurname) {
		this.secondSurname = TextHelper.getDefaultWithTrim(secondSurname);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(final String email) {
		this.email = TextHelper.getDefaultWithTrim(email);
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(final String phoneNumber) {
		this.phoneNumber = TextHelper.getDefaultWithTrim(phoneNumber);
	}
	public boolean isEmailConfirmed() {
		return emailConfirmed;
	}
	public void setEmailConfirmed(final boolean emailConfirmed) {
		this.emailConfirmed = BooleanHelper.getDefault(emailConfirmed);
	}
	public boolean isPhoneConfirmed() {
		return phoneConfirmed;
	}
	public void setPhoneConfirmed(final boolean phoneConfirmed) {
		this.phoneConfirmed = BooleanHelper.getDefault(phoneConfirmed);
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(final boolean isActive) {
		this.isActive = BooleanHelper.getDefault(isActive);
	}

}
