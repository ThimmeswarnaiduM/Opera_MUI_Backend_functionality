package attributes;

import java.io.IOException;
import java.net.Proxy;

import com.squareup.okhttp.Authenticator;
import com.squareup.okhttp.Credentials;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
public class InvokeRestFullWebservices {
	public static InvokeRestFullWebservices invokeRestFullWebservicesSingleTonOBJ=null;
	public static OkHttpClient client = null;
	public static final MediaType JSON= MediaType.parse("application/vnd.oracle.adf.resourceitem+json");
	public InvokeRestFullWebservices()
	{
		
	}
	public  InvokeRestFullWebservices(final String userName,final String password)
	{
		
		
		 client.setAuthenticator(new Authenticator() {
			
	            	            public Request authenticate(Proxy proxy, Response response) throws IOException {
	                String credential = Credentials.basic(userName, password);
	                return response.request().newBuilder().header("Authorization", credential).build();
	            }

	           
	            public Request authenticateProxy(Proxy proxy, Response response) throws IOException {
	                return null;
	            }
	        });
		
		
	}
	/*
	//returning singleton object
	 public static InvokeRestFullWebservices getInstance() 
	 {
		 if (client == null) {
			 client = new OkHttpClient();
	        }
	        if (invokeRestFullWebservicesSingleTonOBJ == null) {
	        	invokeRestFullWebservicesSingleTonOBJ = new InvokeRestFullWebservices();
	        }
	        return invokeRestFullWebservicesSingleTonOBJ;
	 }
	 */
	//returning singleton object
		 public static InvokeRestFullWebservices getInstance(final String userName,final String password) 
		 {
			 if (client == null) 
			    {
				 client = new OkHttpClient();
		        }
		        if (invokeRestFullWebservicesSingleTonOBJ == null)
		        {
		        	invokeRestFullWebservicesSingleTonOBJ = new InvokeRestFullWebservices(userName,password);
		        }
		        return invokeRestFullWebservicesSingleTonOBJ;
		 }
		//handling GET Request
		 public String doGetRequest(String url) throws IOException {
		      Request request = new Request.Builder()
		          .url(url)
		          .build();

		      Response response = client.newCall(request).execute();
		      return response.body().string();
		    }
		 
		 //handling Post Request
		 public Response doPostRequest(String url, String json,int count) throws IOException {
		      RequestBody body = RequestBody.create(JSON, json);
		        Request request = new Request.Builder()
		            .url(url)
		            .post(body)
		            .build();
		        
		        Response response = client.newCall(request).execute();
	        
			return response;
		    }
		 //handling Patch Request
		 String doPatchRequest(String url, String json) throws IOException 
		 {
		         RequestBody body = RequestBody.create(JSON, json);
		        Request request = new Request.Builder()
		                .url(url)
		                .patch(body)
		                .build()
		                ;
		        Response response = client.newCall(request).execute();
		        
		    System.out.println(response.code());
		        return response.body().string();
		    }

}