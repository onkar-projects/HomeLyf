package HomeLyf.EndPoints;

import static io.restassured.RestAssured.given;

import HomeLyf.Payload.QDTAS_UserAddPayload;
import HomeLyf.Payload.QDTAS_UserChangePassword;
import HomeLyf.Payload.QDTAS_UserChangeTempPasswordPayload;
import HomeLyf.Payload.QDTAS_UserLoginPayload;
import HomeLyf.Payload.QDTAS_UserUpdatePayload;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class QDTAS_UserEndPoint {

	public static Response QDTAS_UserLogin(QDTAS_UserLoginPayload Payload) {
		Response response = RestAssured.given().contentType(ContentType.JSON).body(Payload).log().all().when()
				.post(Routes.qdtasUserLogin);

		return response;
	}

	public static Response QDTAS_UserChgTempPassword(QDTAS_UserChangeTempPasswordPayload Payload) {
		Response response = given().contentType(ContentType.JSON).body(Payload).log().all().when()
				.post(Routes.qdtasUserChgTempPassword);

		return response;
	}

	public static Response QDTAS_UserChangePassWord(QDTAS_UserChangePassword Payload) {
		Response response = given().contentType(ContentType.JSON).body(Payload).log().all().when()
				.post(Routes.qdtasUserChangePass);

		return response;
	}

	public static Response QDTAS_UserAdd(String token, QDTAS_UserAddPayload Payload) {
		Response response = given().header("Authorization", "Bearer " + token).contentType(ContentType.JSON).body(Payload).log().all().when()
				.post(Routes.qdtasUserAdd);

		return response;
	}

	public static Response QDTAS_UserUpdate(String token,QDTAS_UserUpdatePayload Payload,String userid) {
		Response response = given().contentType(ContentType.JSON).header("Authorization", "Bearer " + token).body(Payload).log().all().when()
				.post(Routes.qdtasUserUpdate,userid);

		return response;
	}
	public static Response QDTAS_UserTokenVerification(String bearerToken) {
		System.out.println(bearerToken);
		Response response = given().contentType(ContentType.JSON).log().all().when().get(Routes.qdtasUserTokenVerify, bearerToken);
		
		return response;
	}

	public static Response QDTAS_UserEnable(String token,String userId) {
		Response response = given().contentType(ContentType.JSON).header("Authorization", "Bearer " + token).log().all().when().post(Routes.qdtasUserEnable,userId);
		
		return response;
	}

	public static Response QDTAS_UserDelete(String token,String userId) {
		Response response = given().contentType(ContentType.JSON).header("Authorization", "Bearer " + token).queryParam("uId", userId).log().all().when().post(Routes.qdtasUserDelete);
		
		return response;
	}

	

//	public static Response QDTAS_UserResetPassword(QDtas Payload) {
//		Response response = given().contentType(ContentType.JSON).body(Payload).log().all().when().post(Routes.qdtasUserResetPassword);
//		
//		return response;
//	}

}
