package hometask.tests;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import hometask.pojo.User;

public class ApacheHttpClientUsersTest {

	private final static int EXPECTED_NUMBER_OF_USERS = 10;
	private final static String URL = "jsonplaceholder.typicode.com";
	private final static String PATH = "/users";
	private final static String SCHEME = "http";
	private final static String VALUE_OF_CONTENT_TYPE_HEADER = "application/json; charset=utf-8";
	private final static String CONTENT_TYPE_HEADER = "content-type";
	private URI uri;

	@BeforeClass
	private void buildUri() throws URISyntaxException {
		uri = new URIBuilder().setScheme(SCHEME).setHost(URL).setPath(PATH).build();
	}

	@Test
	public void checkStatusCodeTest() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(uri);
		CloseableHttpResponse response = httpclient.execute(httpGet);
		int actualStatusCode = response.getStatusLine().getStatusCode();
		Assert.assertEquals(actualStatusCode, HttpStatus.SC_OK);
	}

	@Test
	public void checkResponseHeader() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(uri);
		CloseableHttpResponse response = httpclient.execute(httpGet);
		Assert.assertTrue(Arrays.toString(response.getHeaders(CONTENT_TYPE_HEADER)).
				contains(VALUE_OF_CONTENT_TYPE_HEADER));
	}

	@Test
	public void checkResponseBody() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(uri);
		CloseableHttpResponse response = httpclient.execute(httpGet);
		ObjectMapper objectMapper = new ObjectMapper();
		User[] users = objectMapper.readValue(response.getEntity().getContent(), User[].class);
		Assert.assertEquals(users.length, EXPECTED_NUMBER_OF_USERS);
	}

}
