package hometask.tests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import hometask.pojo.User;
import io.restassured.RestAssured;

public class RestAssuredUsersTest {

	private final static int STATUS_CODE_200 = 200;
	private final static int EXPECTED_NUMBER_OF_USERS = 10;

	@BeforeTest
	public void initTest() {
		RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
		RestAssured.basePath = "/users";
	}

	@Test
	public void checkStatusCode() {
		given().get().then().statusCode(STATUS_CODE_200);
	}

	@Test
	public void checkResponseHeader() {
		given().get().then().header("content-type", "application/json; charset=utf-8");
	}

	@Test
	public void checkResponseBody() {
		String responseBodyStr = given().get().asString();
		Gson gson = new Gson();
		User[] users = gson.fromJson(responseBodyStr, User[].class);
		Assert.assertEquals(users.length, EXPECTED_NUMBER_OF_USERS);
	}
}
