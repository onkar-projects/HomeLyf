package HomeLyf.EndPoints;

public class Routes {

	public static String base_url = "https://homelyf-demo.onrender.com";
	public static String sendEmail = base_url + "/api/sendEmail-otp";
	public static String verifyotp = base_url + "/api/verify-otp";
	public static String signup = base_url + "/api/signup";
	public static String signin = base_url + "/api/signin";
	public static String forgotPasswordOTP = base_url + "/api/sendEmail-forgotPassword-otp";
	public static String forgotPassword = base_url + "/api/forgotpassword";
	
//	partner 
	
	public static String sendEmailPartner = base_url +"/sp/sendEmail-otp-partner";
	public static String verifyPartnerOtp = base_url + "/sp/verify-otp-partner";
	public static String signupPartner = base_url + "/sp/verify-otp-partner";
	public static String signinPartner = base_url + "/sp/signin-partner";
	public static String forgotPasswordOTPPartner = base_url + "/sp/sendEmail-forgotPassword-otp-partner";
	public static String forgotPasswordPartner = base_url + "/sp/forgotpassword-partner";
	
//	Qdtas HRm User
	public static String qdtasBaseURL = "https://qdtashrm-backend.onrender.com";
	public static String qdtasUserLogin = qdtasBaseURL+"/user/login";
	public static String qdtasUserEnable = qdtasBaseURL+"/user/enableUser/{userId}";
	public static String qdtasUserDelete = qdtasBaseURL+"/user/deleteUser";
	public static String qdtasUserChgTempPassword = qdtasBaseURL+"/user/changeTempPassword";
	public static String qdtasUserChangePass = qdtasBaseURL+"/user/changePassword";
	public static String qdtasUserAdd = qdtasBaseURL+"/user/add";
	public static String qdtasUserTokenVerify = qdtasBaseURL+"/user/verify/{token}";
	public static String qdtasUserUpdate = qdtasBaseURL+"/user/updateUser/{userId}";
	public static String qdtasUserResetPassword = qdtasBaseURL+"/user/resetPassword";
	
	
}
