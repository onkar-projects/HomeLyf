package HomeLyf.EndPoints;

import static io.restassured.RestAssured.*;

import HomeLyf.Payload.ForgotPasswordOTP_Payload;
import HomeLyf.Payload.ForgotPassword_Payload;
import HomeLyf.Payload.SendEmailOTP_Payload;
import HomeLyf.Payload.SignIn_Payload;
import HomeLyf.Payload.SignUP_Payload;
import HomeLyf.Payload.VerifyOTP_Payload;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {

	public static Response sendEmail(SendEmailOTP_Payload Payload) {
		Response response = given().contentType(ContentType.JSON).body(Payload).log().all().when().post(Routes.sendEmail);
		
		return response;
	}

	public static Response verifyOtp(VerifyOTP_Payload Payload) {
		Response response = given().contentType(ContentType.JSON).log().all().body(Payload).when().post(Routes.verifyotp);
		return response;
	}

	public static Response signUp(SignUP_Payload Payload) {
		Response response = given().contentType(ContentType.JSON).body(Payload).log().all().when().post(Routes.signup);
		return response;
	}

	public static Response signIn(SignIn_Payload Payload) {
		Response response = given().contentType(ContentType.JSON).body(Payload).log().all().when().post(Routes.signin);
		return response;
	}

	public static Response forgotPasswordOTP(ForgotPasswordOTP_Payload Payload) {
		Response response = given().contentType(ContentType.JSON).body(Payload).when().post(Routes.forgotPasswordOTP);
		return response;
	}

	public static Response forgotPassword(ForgotPassword_Payload Payload) {
		Response response = given().contentType(ContentType.JSON).body(Payload).log().all().when().post(Routes.forgotPassword);
		return response;
	}
}
