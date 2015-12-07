package io.sprucehill.urbanairship.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Base64;

/**
 * Abstract base service class
 *
 * @author Michael Duergner <michael@sprucehill.io>
 */
public abstract class AbstractService {

    /**
     * The UrbanAirship specific content type which needs to be accepted
     */
    public static final String ACCEPT_CONTENT_TYPE = "application/vnd.urbanairship+json; version=3;";

    /**
     * The UrbanAirship API base URI fragment
     */
    public static final String API_BASE = "https://go.urbanairship.com";

    Logger logger = LoggerFactory.getLogger(getClass());

    HttpClient httpClient;

    ObjectMapper objectMapper;

    String masterAuthorizationHeader;

    /**
     * We will create a default instance for both httpClient as well as objectMapper if they haven't be set externally
     *
     */
    @PostConstruct
    public final void postConstruct() {
        if (null == httpClient) {
            httpClient = HttpClientBuilder.create().build();
        }
        if (null == objectMapper) {
            objectMapper = new ObjectMapper();
        }
        onPostConstruct();
    }

    protected void onPostConstruct() {}

    /**
     * Set the HttpClient instance to use
     *
     * @param httpClient    The HttpClient instance
     */
    public void setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Set the ObjectMapper instance to use
     *
     * @param objectMapper    The ObjectMapper instance
     */
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * Set the master authorization;
     *
     * @param username    The username to use
     * @param password    The password aka. master secret key
     */
    public void setMasterAuthorization(String username, String password) {
        masterAuthorizationHeader = "Basic "+ Base64.getEncoder().encodeToString((username+ ":" + password).getBytes(Charset.forName("UTF-8")));
    }

    /**
     * Create a HttpGet request for the submitted path
     *
     * @param path    The path of the request
     * @return        A HttpGet request instance
     */
    HttpGet getRequest(String path) {
        return new HttpGet(normalizePath(path));
    }

    /**
     * Create a HttpPost request for the submitted path
     *
     * @param path    The path of the request
     * @return        A HttpPost request instance
     */
    HttpPost postRequest(String path) {
        return new HttpPost(normalizePath(path));
    }

    /**
     * Send a HttpRequest; this method will set 'Authorization' as well as 'Accept' headers if not already set on the request.
     *
     * @param request    The request to submit
     * @return           A HttpResponse object
     * @throws IOException Any IOException that occurs on the httpClient while executing the request
     */
    HttpResponse sendRequest(HttpUriRequest request) throws IOException {
        if (0 == request.getHeaders(HttpHeaders.AUTHORIZATION).length) {
            request.addHeader(HttpHeaders.AUTHORIZATION,masterAuthorizationHeader);
        }
        request.addHeader(HttpHeaders.ACCEPT,ACCEPT_CONTENT_TYPE);
        return httpClient.execute(request);
    }

    private String normalizePath(String path) {
        return API_BASE + (path.startsWith("/") ? path : "/" + path);
    }
}
