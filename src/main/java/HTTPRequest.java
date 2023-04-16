import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import net.sf.jasperreports.data.http.RequestMethod;

public class HTTPRequest {

	private HttpURLConnection connection;
	private URL url;
	String strUrl = "http://my-tera.com/OTP_SYSTEM/Mobile/SystemList.htm";
	
	HTTPRequest() throws MalformedURLException{
		this.url = new URL(strUrl);
	}
	
	public void sendRequest() throws IOException {
		connection = (HttpURLConnection) url.openConnection();	
		connection.setRequestMethod(RequestMethod.GET.name());
		connection.setDoOutput(true);
		OutputStream os = connection.getOutputStream();
		
		os.close();
		int respCode = connection.getResponseCode();
		BufferedReader br = new BufferedReader( new InputStreamReader(connection.getInputStream()) );
		String content;
		while( (content = br.readLine()) != null) {
			System.out.println(content);
		}
		
	}
}
