package com.projectX.OAuth;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.security.sasl.SaslException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FaceBookLoginServlet extends HttpServlet implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**
	* Properties will be as follows, but with values for this app.
	* fbAppSecret=1a234bc1234d1234e1f123g1234567g1
	* fbAppId=123456789012345
	* fbLoginRedirectURL=http://www.yoursite.co.uk/shirofb/FacebookLogin
	*/
	private static final Properties props = new Properties();

	private static final String APP_SECRET = props.get("fbAppSecret").toString();
	private static final String APP_ID = props.get("fbAppId").toString();
	private static final String REDIRECT_URL = props.get("fbLoginRedirectURL").toString();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws SaslException, IOException {
		System.out.println("FacebookLoginServlet getting..");
		FacebookUserDetails fud = authenticate(request, response);
		
		if (fud != null) {
			response.getWriter().write("<html><head/><body><h1>Facebook Logged In</h1><p>"+fud.toString()+"</p></body>");
			response.getWriter().flush();

		} else {
			try {
				System.out.println("fb log in failed");
				String errorReason = request.getParameter("error_reason");
				String error = request.getParameter("error");
				response.getWriter().write("<html><head/><body><h1>fb login failed</h1>" +
				" reason:"+errorReason+" error:"+error+"</body>");
				response.getWriter().flush();
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Unexpected doPost ...");
	}
	private FacebookUserDetails authenticate(HttpServletRequest request, HttpServletResponse response) throws MalformedURLException, IOException {
		FacebookUserDetails fud = null;
		String code = request.getParameter("code");
			if (code != null && code.trim().length() > 0) {
			URL authUrl = new URL("https://graph.facebook.com/oauth/access_token?" + "client_id="
			+ APP_ID + "&redirect_uri=" + REDIRECT_URL + "&client_secret="
			+ APP_SECRET + "&code=" + code);

			String authResponse = readURL(authUrl);
			System.out.println(authResponse);

			try {
			String accessToken = getPropsMap(authResponse).get("access_token");
			URL url = new URL("https://graph.facebook.com/me?access_token=" + accessToken);
			String fbResponse = readURL(url);

			System.out.println(fbResponse);

			fud = new FacebookUserDetails(fbResponse);

			} catch (Throwable e) {
			e.printStackTrace();
			throw new RuntimeException(e);
			}
			}
			return fud;
	}
	private String readURL(URL url) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		InputStream is = url.openStream();
		int r;
		while ((r = is.read()) != -1) {
			baos.write(r);
		}
		return new String(baos.toByteArray());
	}
	
	private Map<String, String> getPropsMap(String someString) {
		String[] pairs = someString.split("&");
		Map<String, String> props = new HashMap<String, String>();
		for (String propPair : pairs) {
			String[] pair = propPair.split("=");
			props.put(pair[0], pair[1]);
		}
		return props;

	}
	
}
