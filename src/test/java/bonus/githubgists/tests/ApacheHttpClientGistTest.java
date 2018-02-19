package bonus.githubgists.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Base64;

import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import bonus.githubgists.pojo.File;
import bonus.githubgists.pojo.Files;
import bonus.githubgists.pojo.Gist;

public class ApacheHttpClientGistTest {


	private final static int EXPECTED_NUMBER_OF_GISTS = 11;
	private final static String URL = "api.github.com";
	private final static String PATH = "/gists";
	private final static String SCHEME = "https";
	private String encoding;

	private URI uri;

	@BeforeClass
	private void buildUri() throws URISyntaxException {
		uri = new URIBuilder().setScheme(SCHEME).setHost(URL).setPath(PATH).build();
		encoding = Base64.getEncoder().encodeToString(("login:password").getBytes());
	}

	/** Get all user gists -> check status code */
	@Test(description = "GET method using")
	public void getUserGistsAndChechStatusCode() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(uri);
		httpGet.setHeader("Authorization", "Basic " + encoding);
		CloseableHttpResponse response = httpclient.execute(httpGet);
		int actualStatusCode = response.getStatusLine().getStatusCode();
		assertEquals(actualStatusCode,  HttpStatus.SC_OK);
	}

	@Test(description = "POST method using")
	public void createNewGistAndCheckStatusCode() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(uri);
		httpPost.setHeader("Authorization", "Basic " + encoding);
		Gist gist = createGistAndSetMinimalRequiredParameters();
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(gist);
		httpPost.setEntity(new StringEntity(jsonInString));
		CloseableHttpResponse response = httpclient.execute(httpPost);
		int actualStatusCode = response.getStatusLine().getStatusCode();
		assertEquals(actualStatusCode,  HttpStatus.SC_CREATED);
	}

	/** Delete a gist with difined id -> check status code equals 204 */
	@Test(description = "DELETE method using")
	public void deleteGistAndCheckStatusCode() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpDelete httpDelete = new HttpDelete(uri + "/ca71977cd92a3b4f15eb593e278a4a11");
		httpDelete.setHeader("Authorization", "Basic " + encoding);
		CloseableHttpResponse response = httpclient.execute(httpDelete);
		int actualStatusCode = response.getStatusLine().getStatusCode();
		assertEquals(actualStatusCode, HttpStatus.SC_NO_CONTENT);
	}


	/** Star a gist with difined id -> check status code equals 204 */
	@Test(description = "PUT method using")
	public void starGistAndCheckStatusCode() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPut httpPut = new HttpPut(uri + "/df6487abbff5baa0ce9e3339bbe9cb26/star");
		httpPut.setHeader("Authorization", "Basic " + encoding);
		CloseableHttpResponse response = httpclient.execute(httpPut);
		int actualStatusCode = response.getStatusLine().getStatusCode();
		assertEquals(actualStatusCode, HttpStatus.SC_NO_CONTENT);
	}

	/** Unstar a gist with difined id -> check status code equals 204 */
	@Test(description = "DELETE method using")
	public void unstarGistAndCheckStatusCode() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpDelete httpDel = new HttpDelete(uri + "/df6487abbff5baa0ce9e3339bbe9cb26/star");
		httpDel.setHeader("Authorization", "Basic " + encoding);
		CloseableHttpResponse response = httpclient.execute(httpDel);
		int actualStatusCode = response.getStatusLine().getStatusCode();
		assertEquals(actualStatusCode, HttpStatus.SC_NO_CONTENT);
	}

	/** Update a gist with difined id -> check status code equals 200 */
	@Test(description = "PATCH method using")
	public void updateGistAndCheckStatusCode() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPatch httpPatch = new HttpPatch(uri + "/df6487abbff5baa0ce9e3339bbe9cb26");
		httpPatch.setHeader("Authorization", "Basic " + encoding);
		Gist updatedGist = createGistAndSetMinimalRequiredParameters();
		updatedGist.setDescription("updated description");
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(updatedGist);
		httpPatch.setEntity(new StringEntity(jsonInString));
		CloseableHttpResponse response = httpclient.execute(httpPatch);
		int actualStatusCode = response.getStatusLine().getStatusCode();
		assertEquals(actualStatusCode, HttpStatus.SC_OK);
	}

	/** Get all user gists -> deserialize body -> check number of gists */
	@Test(description = "Get method using")
	public void getAllGistsAndCheckBody() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(uri);
		httpGet.setHeader("Authorization", "Basic " + encoding);
		CloseableHttpResponse response = httpclient.execute(httpGet);
		ObjectMapper objectMapper = new ObjectMapper();
		Gist[] gists = objectMapper.readValue(response.getEntity().getContent(), Gist[].class);
		assertEquals(gists.length, EXPECTED_NUMBER_OF_GISTS);
	}

	private Gist createGistAndSetMinimalRequiredParameters(){
		Gist gist = new Gist();
		gist.setDescription("New gist is created by auto test");
		gist.setPublic(true);
		Files files = new Files();
		File file = new File();
		file.setContent("content is created by auto test");
		files.setFile(file);
		gist.setFiles(files);
		return gist;
	}

}
