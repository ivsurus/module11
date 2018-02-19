package hometask.tests;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;

import hometask.pojo.User;

public class RestTemplateUsersTest {

	private final static String USERS_ENDPOINT = "http://jsonplaceholder.typicode.com/users";
	private final static String VALUE_OF_CONTENT_TYPE_HEADER = "application/json; charset=utf-8";
	private final static String CONTENT_TYPE_HEADER = "content-type";
	private final static int EXPECTED_NUMBER_OF_USERS = 10;

	@Test
	public void checkStatusCode() {
		RestTemplate restTeampl = new RestTemplate();
		ResponseEntity<User[]> response = restTeampl.getForEntity(USERS_ENDPOINT, User[].class);
		int actualStatusCode = response.getStatusCodeValue();
		Assert.assertEquals(actualStatusCode, HttpStatus.OK.value());
	}

	@Test
	public void checkResponseHeader() {
		RestTemplate restTeampl = new RestTemplate();
		ResponseEntity<User[]> response = restTeampl.getForEntity(USERS_ENDPOINT, User[].class);
		List<String> actualValueOfContentTypeHeader = response.getHeaders().get(CONTENT_TYPE_HEADER);
		Assert.assertEquals(actualValueOfContentTypeHeader.get(0), VALUE_OF_CONTENT_TYPE_HEADER);
	}

	@Test
	public void checkResponseBody() {
		RestTemplate restTeampl = new RestTemplate();
		ResponseEntity<User[]> response = restTeampl.getForEntity(USERS_ENDPOINT, User[].class);
		Assert.assertEquals(response.getBody().length, EXPECTED_NUMBER_OF_USERS);
	}
}
