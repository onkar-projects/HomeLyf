package HomeLyf.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import HomeLyf.EndPoints.QDTAS_UserEndPoint;
import HomeLyf.Payload.QDTAS_UserAddPayload;
import HomeLyf.Payload.QDTAS_UserLoginPayload;
import HomeLyf.Payload.QDTAS_UserUpdatePayload;
import HomeLyf.Utilities.CommonMethods;
import HomeLyf.Utilities.DataProvider;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class QDTAS_LoginTestCase {

	QDTAS_UserLoginPayload loginUser;
	QDTAS_UserUpdatePayload updateUser;
	QDTAS_UserAddPayload addUser;
	String Authorization = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBnbWFpbC5jb20iLCJleHAiOjE3MTA4NjE2NDIsImlhdCI6MTcxMDgyNTY0Mn0.6QDTydb_SbDvGGNRGNtpd6nsyBBvDk7qiVNBF7G__tI";
	String token;
	String userId;
	String emailId = "riloro8063@hisotyr.com";
	String pass;

	@BeforeTest
	public void QDTAS_data() {
		loginUser = new QDTAS_UserLoginPayload();
		updateUser = new QDTAS_UserUpdatePayload();
		addUser = new QDTAS_UserAddPayload();
	}

	@Test(priority = 1, dataProvider = "qdtasLoginDetails", dataProviderClass = DataProvider.class)
	public void qdtasLoginUserTest(String email, String password) {

		loginUser.setEmail(email);
		loginUser.setPassword(password);

		Response response = QDTAS_UserEndPoint.QDTAS_UserLogin(loginUser);
		response.then().log().all();

		String res = response.asPrettyString();
		JsonPath js = new JsonPath(res);

		this.token = js.getString("token");
		System.out.println("Token :=> " + token);

		Assert.assertEquals(response.statusCode(), 200);

	}

	@Test(priority = 2)
	public void qdtasVerifyUserTokenTest() {
		System.out.println("Token in 2 :=> " + token);
		Response response = QDTAS_UserEndPoint.QDTAS_UserTokenVerification(token);
		response.then().log().all();

		JsonPath js = CommonMethods.jsonToString(response);
		String msg = js.getString("message");

		Assert.assertEquals(msg, "Verification Successfull");
		Assert.assertEquals(response.statusCode(), 200);
	}

	@Test(priority = 3, dataProvider = "qdtasNewUserDetails", dataProviderClass = DataProvider.class)
	public void qdtasAddUser(String uname, String email, String pass, String fname, String mname, String lname,
			String gender, String deptId, String role, String phno, String designation, String bday) {

		addUser.setUserName(uname);
		addUser.setEmail(email);
		addUser.setPassword(pass);
		addUser.setFirstName(fname);
		addUser.setMiddleName(mname);
		addUser.setLastName(lname);
		addUser.setGender(gender);
		addUser.setDeptId(deptId);
		addUser.setRole(role);
		addUser.setPhoneNumber(phno);
		addUser.setDesignation(designation);
		addUser.setBirthDate(bday);

		Response response = QDTAS_UserEndPoint.QDTAS_UserAdd(token, addUser);
		response.then().log().all();

		JsonPath js = CommonMethods.jsonToString(response);

		this.userId = js.getString("userId");
		System.out.println("userID = " + userId);
		Assert.assertEquals(response.statusCode(), 201);
	}

	@Test(priority = 4)
	public void qdtasEnableUser() {

		Response response = QDTAS_UserEndPoint.QDTAS_UserEnable(token, userId);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
	}

	@Test(priority = 5, dataProvider = "qdtasNewLoginDetails", dataProviderClass = DataProvider.class)
	public void qdtasLoginNewUserTest(String email, String pass) {

		loginUser.setEmail(email);
		loginUser.setPassword(pass);

		Response response = QDTAS_UserEndPoint.QDTAS_UserLogin(loginUser);
		response.then().log().all();

		String res = response.asPrettyString();
		JsonPath js = new JsonPath(res);

		this.token = js.getString("token");
		System.out.println("Token :=> " + token);

		Assert.assertEquals(response.statusCode(), 200);

	}

	@Test(priority = 6, dataProvider = "qdtasUpdateUserDetails", dataProviderClass = DataProvider.class)
	public void qdtasUpdateUser(String uname, String email, String pass, String fname, String mname, String lname,
			String gender, String deptId, String role, String phNo, String destination, String bdate,
			String joiningDate, String address) {

		updateUser.setUserName(uname);
		updateUser.setEmail(email);
		updateUser.setPassword(pass);
		updateUser.setFirstName(fname);
		updateUser.setMiddleName(mname);
		updateUser.setLastName(lname);
		updateUser.setGender(gender);
		updateUser.setDeptId(deptId);
		updateUser.setRole(role);
		updateUser.setPhoneNumber(phNo);
		updateUser.setDesignation(destination);
		updateUser.setEmailVerified(true);
		updateUser.setBirthDate(bdate);
		updateUser.setJoinDate(joiningDate);
		updateUser.setAddress(address);

		Response response = QDTAS_UserEndPoint.QDTAS_UserUpdate(token, updateUser, userId);
		response.then().log().all();

		Assert.assertEquals(response.statusCode(), 200);
	}

//	@Test(priority = 7, enabled = false)
//	public void qdtasDeleteUserTest() {
//
//		Response response = QDTAS_UserEndPoint.QDTAS_UserDelete(token, userId);
//		response.then().log().all();
//
//		Assert.assertEquals(response.statusCode(), 200);
//
//	}

}
