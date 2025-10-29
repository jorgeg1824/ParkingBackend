package co.edu.uco.parking.dto;

import java.util.UUID;

public final class ManagerDTO {

	private UUID id;
	private String documentNumber;
	private String name;
	private String firstSurname;
	private String secondSurname;
	private String email;
	private String phoneNumber;
	private boolean emailConfirmed;
	private boolean phoneConfirmed;
	private boolean active;
	
	public ManagerDTO() {
		this.id = null;
		this.documentNumber = "";
		this.name = "";
		this.firstSurname = "";
		this.secondSurname = "";
		this.email = "";
		this.phoneNumber = "";
		this.emailConfirmed = false;
		this.phoneConfirmed = false;
		this.active = false;
	}
	
	public ManagerDTO(final UUID id, final String documentNumber, final String name, final String firstSurname,
			final String secondSurname, final String email, final String phoneNumber,
			final boolean emailConfirmed, final boolean phoneConfirmed, final boolean active) {
		this.id = id;
		this.documentNumber = documentNumber;
		this.name = name;
		this.firstSurname = firstSurname;
		this.secondSurname = secondSurname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.emailConfirmed = emailConfirmed;
		this.phoneConfirmed = phoneConfirmed;
		this.active = active;
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(final String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getFirstSurname() {
		return firstSurname;
	}

	public void setFirstSurname(final String firstSurname) {
		this.firstSurname = firstSurname;
	}

	public String getSecondSurname() {
		return secondSurname;
	}

	public void setSecondSurname(final String secondSurname) {
		this.secondSurname = secondSurname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(final String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isEmailConfirmed() {
		return emailConfirmed;
	}

	public void setEmailConfirmed(final boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}

	public boolean isPhoneConfirmed() {
		return phoneConfirmed;
	}

	public void setPhoneConfirmed(final boolean phoneConfirmed) {
		this.phoneConfirmed = phoneConfirmed;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(final boolean active) {
		this.active = active;
	}
}
