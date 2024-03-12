package HomeLyf.Payload;

public class SendEmailOTPPartner_Payload {
	
	
	private String email;

	public SendEmailOTPPartner_Payload(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
