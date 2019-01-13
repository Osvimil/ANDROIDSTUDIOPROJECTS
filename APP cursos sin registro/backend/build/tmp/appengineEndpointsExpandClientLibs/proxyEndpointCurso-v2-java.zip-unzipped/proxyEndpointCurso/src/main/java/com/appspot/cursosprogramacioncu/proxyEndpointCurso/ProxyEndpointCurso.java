/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://github.com/google/apis-client-generator/
 * (build: 2016-05-19 20:48:09 UTC)
 * on 2016-05-31 at 14:57:33 UTC 
 * Modify at your own risk.
 */

package com.appspot.cursosprogramacioncu.proxyEndpointCurso;

/**
 * Service definition for ProxyEndpointCurso (v2).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link ProxyEndpointCursoRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class ProxyEndpointCurso extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.22.0 of the proxyEndpointCurso library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://myApplicationId.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "proxyEndpointCurso/v2/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   */
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport, which should normally be:
   *        <ul>
   *        <li>Google App Engine:
   *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
   *        <li>Android: {@code newCompatibleTransport} from
   *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
   *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
   *        </li>
   *        </ul>
   * @param jsonFactory JSON factory, which may be:
   *        <ul>
   *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
   *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
   *        <li>Android Honeycomb or higher:
   *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
   *        </ul>
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public ProxyEndpointCurso(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  ProxyEndpointCurso(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "insertCurso".
   *
   * This request holds the parameters needed by the proxyEndpointCurso server.  After setting any
   * optional parameters, call the {@link InsertCurso#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.appspot.cursosprogramacioncu.proxyEndpointCurso.model.Curso}
   * @return the request
   */
  public InsertCurso insertCurso(com.appspot.cursosprogramacioncu.proxyEndpointCurso.model.Curso content) throws java.io.IOException {
    InsertCurso result = new InsertCurso(content);
    initialize(result);
    return result;
  }

  public class InsertCurso extends ProxyEndpointCursoRequest<Void> {

    private static final String REST_PATH = "insert_Curso";

    /**
     * Create a request for the method "insertCurso".
     *
     * This request holds the parameters needed by the the proxyEndpointCurso server.  After setting
     * any optional parameters, call the {@link InsertCurso#execute()} method to invoke the remote
     * operation. <p> {@link
     * InsertCurso#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param content the {@link com.appspot.cursosprogramacioncu.proxyEndpointCurso.model.Curso}
     * @since 1.13
     */
    protected InsertCurso(com.appspot.cursosprogramacioncu.proxyEndpointCurso.model.Curso content) {
      super(ProxyEndpointCurso.this, "POST", REST_PATH, content, Void.class);
    }

    @Override
    public InsertCurso setAlt(java.lang.String alt) {
      return (InsertCurso) super.setAlt(alt);
    }

    @Override
    public InsertCurso setFields(java.lang.String fields) {
      return (InsertCurso) super.setFields(fields);
    }

    @Override
    public InsertCurso setKey(java.lang.String key) {
      return (InsertCurso) super.setKey(key);
    }

    @Override
    public InsertCurso setOauthToken(java.lang.String oauthToken) {
      return (InsertCurso) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertCurso setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (InsertCurso) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertCurso setQuotaUser(java.lang.String quotaUser) {
      return (InsertCurso) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertCurso setUserIp(java.lang.String userIp) {
      return (InsertCurso) super.setUserIp(userIp);
    }

    @Override
    public InsertCurso set(String parameterName, Object value) {
      return (InsertCurso) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "insertPremium".
   *
   * This request holds the parameters needed by the proxyEndpointCurso server.  After setting any
   * optional parameters, call the {@link InsertPremium#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.appspot.cursosprogramacioncu.proxyEndpointCurso.model.CursoPremium}
   * @return the request
   */
  public InsertPremium insertPremium(com.appspot.cursosprogramacioncu.proxyEndpointCurso.model.CursoPremium content) throws java.io.IOException {
    InsertPremium result = new InsertPremium(content);
    initialize(result);
    return result;
  }

  public class InsertPremium extends ProxyEndpointCursoRequest<Void> {

    private static final String REST_PATH = "insert_CursoPremium";

    /**
     * Create a request for the method "insertPremium".
     *
     * This request holds the parameters needed by the the proxyEndpointCurso server.  After setting
     * any optional parameters, call the {@link InsertPremium#execute()} method to invoke the remote
     * operation. <p> {@link InsertPremium#initialize(com.google.api.client.googleapis.services.Abstra
     * ctGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param content the {@link com.appspot.cursosprogramacioncu.proxyEndpointCurso.model.CursoPremium}
     * @since 1.13
     */
    protected InsertPremium(com.appspot.cursosprogramacioncu.proxyEndpointCurso.model.CursoPremium content) {
      super(ProxyEndpointCurso.this, "POST", REST_PATH, content, Void.class);
    }

    @Override
    public InsertPremium setAlt(java.lang.String alt) {
      return (InsertPremium) super.setAlt(alt);
    }

    @Override
    public InsertPremium setFields(java.lang.String fields) {
      return (InsertPremium) super.setFields(fields);
    }

    @Override
    public InsertPremium setKey(java.lang.String key) {
      return (InsertPremium) super.setKey(key);
    }

    @Override
    public InsertPremium setOauthToken(java.lang.String oauthToken) {
      return (InsertPremium) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertPremium setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (InsertPremium) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertPremium setQuotaUser(java.lang.String quotaUser) {
      return (InsertPremium) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertPremium setUserIp(java.lang.String userIp) {
      return (InsertPremium) super.setUserIp(userIp);
    }

    @Override
    public InsertPremium set(String parameterName, Object value) {
      return (InsertPremium) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "list".
   *
   * This request holds the parameters needed by the proxyEndpointCurso server.  After setting any
   * optional parameters, call the {@link List#execute()} method to invoke the remote operation.
   *
   * @return the request
   */
  public List list() throws java.io.IOException {
    List result = new List();
    initialize(result);
    return result;
  }

  public class List extends ProxyEndpointCursoRequest<com.appspot.cursosprogramacioncu.proxyEndpointCurso.model.CursoCollection> {

    private static final String REST_PATH = "curso";

    /**
     * Create a request for the method "list".
     *
     * This request holds the parameters needed by the the proxyEndpointCurso server.  After setting
     * any optional parameters, call the {@link List#execute()} method to invoke the remote operation.
     * <p> {@link
     * List#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)} must be
     * called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @since 1.13
     */
    protected List() {
      super(ProxyEndpointCurso.this, "GET", REST_PATH, null, com.appspot.cursosprogramacioncu.proxyEndpointCurso.model.CursoCollection.class);
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public List setAlt(java.lang.String alt) {
      return (List) super.setAlt(alt);
    }

    @Override
    public List setFields(java.lang.String fields) {
      return (List) super.setFields(fields);
    }

    @Override
    public List setKey(java.lang.String key) {
      return (List) super.setKey(key);
    }

    @Override
    public List setOauthToken(java.lang.String oauthToken) {
      return (List) super.setOauthToken(oauthToken);
    }

    @Override
    public List setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (List) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public List setQuotaUser(java.lang.String quotaUser) {
      return (List) super.setQuotaUser(quotaUser);
    }

    @Override
    public List setUserIp(java.lang.String userIp) {
      return (List) super.setUserIp(userIp);
    }

    @Override
    public List set(String parameterName, Object value) {
      return (List) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "listPremium".
   *
   * This request holds the parameters needed by the proxyEndpointCurso server.  After setting any
   * optional parameters, call the {@link ListPremium#execute()} method to invoke the remote
   * operation.
   *
   * @return the request
   */
  public ListPremium listPremium() throws java.io.IOException {
    ListPremium result = new ListPremium();
    initialize(result);
    return result;
  }

  public class ListPremium extends ProxyEndpointCursoRequest<com.appspot.cursosprogramacioncu.proxyEndpointCurso.model.CursoPremiumCollection> {

    private static final String REST_PATH = "cursopremium";

    /**
     * Create a request for the method "listPremium".
     *
     * This request holds the parameters needed by the the proxyEndpointCurso server.  After setting
     * any optional parameters, call the {@link ListPremium#execute()} method to invoke the remote
     * operation. <p> {@link
     * ListPremium#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @since 1.13
     */
    protected ListPremium() {
      super(ProxyEndpointCurso.this, "GET", REST_PATH, null, com.appspot.cursosprogramacioncu.proxyEndpointCurso.model.CursoPremiumCollection.class);
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public ListPremium setAlt(java.lang.String alt) {
      return (ListPremium) super.setAlt(alt);
    }

    @Override
    public ListPremium setFields(java.lang.String fields) {
      return (ListPremium) super.setFields(fields);
    }

    @Override
    public ListPremium setKey(java.lang.String key) {
      return (ListPremium) super.setKey(key);
    }

    @Override
    public ListPremium setOauthToken(java.lang.String oauthToken) {
      return (ListPremium) super.setOauthToken(oauthToken);
    }

    @Override
    public ListPremium setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (ListPremium) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public ListPremium setQuotaUser(java.lang.String quotaUser) {
      return (ListPremium) super.setQuotaUser(quotaUser);
    }

    @Override
    public ListPremium setUserIp(java.lang.String userIp) {
      return (ListPremium) super.setUserIp(userIp);
    }

    @Override
    public ListPremium set(String parameterName, Object value) {
      return (ListPremium) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link ProxyEndpointCurso}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport, which should normally be:
     *        <ul>
     *        <li>Google App Engine:
     *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
     *        <li>Android: {@code newCompatibleTransport} from
     *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
     *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
     *        </li>
     *        </ul>
     * @param jsonFactory JSON factory, which may be:
     *        <ul>
     *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
     *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
     *        <li>Android Honeycomb or higher:
     *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
     *        </ul>
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
        com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link ProxyEndpointCurso}. */
    @Override
    public ProxyEndpointCurso build() {
      return new ProxyEndpointCurso(this);
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    @Override
    public Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (Builder) super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
    }

    @Override
    public Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (Builder) super.setSuppressAllChecks(suppressAllChecks);
    }

    /**
     * Set the {@link ProxyEndpointCursoRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setProxyEndpointCursoRequestInitializer(
        ProxyEndpointCursoRequestInitializer proxyendpointcursoRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(proxyendpointcursoRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
