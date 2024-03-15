package HomeLyf.test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import HomeLyf.EndPoints.UserEndPoints;
import HomeLyf.Payload.ForgotPasswordOTP_Payload;
import HomeLyf.Payload.ForgotPassword_Payload;
import HomeLyf.Payload.SendEmailOTP_Payload;
import HomeLyf.Payload.SignIn_Payload;
import HomeLyf.Payload.SignUP_Payload;
import HomeLyf.Payload.VerifyOTP_Payload;
import HomeLyf.Utilities.DataProvider;
import io.restassured.response.Response;
import junit.framework.Assert;

public class User {

	SendEmailOTP_Payload sendotp;
	VerifyOTP_Payload verifyotp;
	SignUP_Payload signup;
	SignIn_Payload signin;
	ForgotPassword_Payload forgotpass;
	ForgotPasswordOTP_Payload forgotpassOTP;
	
	

	@BeforeTest
	public void data() {

		verifyotp = new VerifyOTP_Payload();
		signup = new SignUP_Payload();
		signin = new SignIn_Payload();
		forgotpass = new ForgotPassword_Payload();
		forgotpassOTP = new ForgotPasswordOTP_Payload();

	}

	@Test(priority = 1,dataProvider = "userEmail", dataProviderClass = DataProvider.class)
	public void sendEmailOTP_Test(String email) {
		sendotp = new SendEmailOTP_Payload(email);
		
		Response response = UserEndPoints.sendEmail(sendotp);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
	}

	@Test(priority = 2,dataProvider = "userEmail", dataProviderClass = DataProvider.class)
	public void verifyOtp_Test(String email) {
		verifyotp.setEmail(email);
		verifyotp.setOTP("4618");
		Response response = UserEndPoints.verifyOtp(verifyotp);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
	}

	@Test(priority = 3, dataProvider = "Data", dataProviderClass = DataProvider.class)
	public void signUp_Test(String name, String email, String mobile, String password, String otp) {
		
		signup.setName(name);
		signup.setEmail(email);
		signup.setMobile(mobile);
		signup.setPassword(password);
		signup.setOtp("6758");
		
		Response response = UserEndPoints.signUp(signup);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
	}

	@Test(priority = 4,  dataProvider = "useremailAndPassword", dataProviderClass = DataProvider.class)
	public void signIn_Test(String email,String password) {
		signin.setEmail(email);
		signin.setPassword(password);
		
		Response response = UserEndPoints.signIn(signin);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
	}

	@Test(priority = 5, dataProvider = "userEmail", dataProviderClass = DataProvider.class)
	public void forgotPasswordOTP_Test(String email) {
		forgotpassOTP.setEmail(email);
		Response response = UserEndPoints.forgotPasswordOTP(forgotpassOTP);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
	}

	@Test(priority = 6, dataProvider = "userEmailAndNewPass", dataProviderClass = DataProvider.class)
	public void forgotPassword_Test(String email,String newpass) {
		forgotpass.setEmail(email);
		forgotpass.setNewPassword(newpass);
		forgotpass.setOtp("3778");
		Response response = UserEndPoints.forgotPassword(forgotpass);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
	}
}
