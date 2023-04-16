import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import net.sf.jasperreports.data.http.RequestMethod;
import net.sf.json.JSONObject;

public class HTTPRequest {

	private HttpURLConnection connection;
	private URL url;
	//String strUrl = "http://my-tera.com/OTP_SYSTEM/Mobile/SystemList.htm";
	String strUrl = "https://dummyjson.com/auth/login";
	HTTPRequest() throws MalformedURLException{
		this.url = new URL(strUrl);
	}
	
	public void sendRequest() throws IOException {
		connection = (HttpURLConnection) url.openConnection();	
		connection.setRequestMethod(RequestMethod.POST.name());
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setRequestProperty("Accept", "application/json");
		
		JSONObject cred = new JSONObject();
		cred.put("username","kminchelle");
		cred.put("password", "0lelplR");
		
		connection.setDoOutput(true);
		OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
		osw.write(cred.toString());
		osw.close();
		int respCode = connection.getResponseCode();
		BufferedReader br = new BufferedReader( new InputStreamReader(connection.getInputStream()) );
		String content;
		while( (content = br.readLine()) != null) {
			System.out.println(content);
		}
		
	}
}
