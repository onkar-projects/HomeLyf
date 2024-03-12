package HomeLyf.EndPoints;

import static io.restassured.RestAssured.given;

import HomeLyf.Payload.ForgotPasswordOTP_Payload;
import HomeLyf.Payload.ForgotPassword_Payload;
import HomeLyf.Payload.SendEmailOTP_Payload;
import HomeLyf.Payload.SignIn_Payload;
import HomeLyf.Payload.SignUP_Payload;
import HomeLyf.Payload.VerifyOTP_Payload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PartnerEndPoitns {
	
	public static Response sendEmailPartner(SendEmailOTP_Payload Payload) {
		Response response = given().contentType(ContentType.JSON).body(Payload).log().all().when().post(Routes.sendEmailPartner);
		
		return response;
	}

	public static Response verifyOtpPartner(VerifyOTP_Payload Payload) {
		Response response = given().contentType(ContentType.JSON).log().all().body(Payload).when().post(Routes.verifyPartnerOtp);
		return response;
	}

	public static Response signUpPartner(SignUP_Payload Payload) {
		Response response = given().contentType(ContentType.JSON).body(Payload).log().all().when().post(Routes.signupPartner);
		return response;
	}

	public static Response signInPartner(SignIn_Payload Payload) {
		Response response = given().contentType(ContentType.JSON).body(Payload).log().all().when().post(Routes.signinPartner);
		return response;
	}

	public static Response forgotPasswordOTPPartner(ForgotPasswordOTP_Payload Payload) {
		Response response = given().contentType(ContentType.JSON).body(Payload).when().post(Routes.forgotPasswordOTPPartner);
		return response;
	}

	public static Response forgotPasswordPartner(ForgotPassword_Payload Payload) {
		Response response = given().contentType(ContentType.JSON).body(Payload).log().all().when().post(Routes.forgotPasswordPartner);
		return response;
	}
}
