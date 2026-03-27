package config;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.StringReader;

import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SoapExecutor {

	public static final String EnrollUser = ""; 
	
   public  String CONTENT_TYPE = "text/xml;charset=UTF-8";
   public   String SOAP_ACTION = "SOAPAction";

   private String endPointUrl;
   private HttpHost proxy = null;

   public SoapExecutor(String endPointURL) {
       this.endPointUrl = endPointURL;
   }
   
   public SoapExecutor() {}

  

   @SuppressWarnings("deprecation")
public String executeRequest(String userName,String password ,String soapAction, String reqXML)
   {

       DefaultHttpClient httpclient = new DefaultHttpClient();
       
       
       String responseStr=null;

       if (proxy != null)
       {
           httpclient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
       }

       HttpPost postMethod = new HttpPost(this.endPointUrl);
       StringEntity reqEntity = null;

       try {
           reqEntity = new StringEntity(reqXML);
           reqEntity.setContentType(CONTENT_TYPE);
           reqEntity = new StringEntity(reqXML, "text/xml", "utf-8");


           postMethod.setHeader(SOAP_ACTION, getSoapAction(soapAction));
           postMethod.setEntity(reqEntity);
           postMethod.addHeader(new BasicScheme().authenticate(new UsernamePasswordCredentials(userName, password), postMethod));

           HttpResponse response = httpclient.execute(postMethod);
           
           

           int statusCode = response.getStatusLine().getStatusCode();
             
           if (statusCode == 200) {
               ResponseHandler<String> handler = new BasicResponseHandler();
               String resBody = handler.handleResponse(response);
               responseStr=resBody;
               //Log.d("tanh :","iusg"+responseStr);
               //System.out.println(resBody);

           } else {
           	
        	   if(response.toString().contains("Content-Encoding: gzip")) {
        		   System.out.println(statusCode);
        		   int statusCode1 = response.getStatusLine().getStatusCode();

        		   GzipDecompressingEntity entity = new GzipDecompressingEntity(response.getEntity());
        		   InputStream val= entity.getContent();
        		   responseStr = IOUtils.toString(val, "UTF-8");
        	
        		   return responseStr;
        	   }
        	   else {
        	   System.out.println(statusCode);
             HttpEntity r_entity = response.getEntity(); // get response
               byte[] result = null;
               int statusCode1 = response.getStatusLine().getStatusCode();
               System.out.println("statusCode1"+statusCode1);
               if (r_entity != null &&r_entity.getContentLength()>0) {
                   result = new byte[(int) r_entity.getContentLength()];
                   if (r_entity.isStreaming()) {
                       DataInputStream is = new DataInputStream(r_entity.getContent());
                       is.readFully(result);
                      
                       String errorResponse = new String(result);
                       System.out.println("errorResponse"+errorResponse);
                       return errorResponse;
                    //   responseStr="";
                       


                   }
               }
        	   }
           }
       } catch (Exception e) {
    	   e.printStackTrace();
       } 


       return responseStr;
   }

   private String getSoapAction(String soapAction) {
       if (soapAction.endsWith("\"") && soapAction.startsWith("\"")) {
           return soapAction;
       } else if (!soapAction.endsWith("\"") && !soapAction.startsWith("\"")) {
           return "\"" + soapAction + "\"";
       } else {
           return soapAction;
       }
   }

   public Document convertStringToDocument(String xmlStr) {
	   //System.out.println("Document: \n"+xmlStr);
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
       DocumentBuilder builder;  
       try  
       {  
           builder = factory.newDocumentBuilder();  
           Document doc = builder.parse( new InputSource( new StringReader( xmlStr ) ) ); 
           return doc;
       } catch (Exception e) {  
           e.printStackTrace();  
       } 	
       return null;
   }
   
   public String getValue(Element e,String value)
	 {
		 String result;
		try
		{
			result = e.getElementsByTagName(value).item(0).getTextContent();
			
			return result.trim().replace("&", "&amp;");
		}
		catch(NullPointerException ex)
		{
			return "";
		}
		
		 
	 }
   
  
   @SuppressWarnings("deprecation")
public String executeMemberQueryRequest(String soapAction, String reqXML)
   {
	   
	   HttpParams my_httpParams = new BasicHttpParams();
	   HttpConnectionParams.setConnectionTimeout(my_httpParams, 70000);
	   HttpConnectionParams.setSoTimeout(my_httpParams, 70000);
       DefaultHttpClient httpclient = new DefaultHttpClient(my_httpParams);
       String responseStr=null;

       if (proxy != null)
       {
           httpclient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
       }

       HttpPost postMethod = new HttpPost(this.endPointUrl);
       StringEntity reqEntity = null;

       try {
           reqEntity = new StringEntity(reqXML);
           reqEntity.setContentType(CONTENT_TYPE);
           reqEntity = new StringEntity(reqXML, "text/xml", "utf-8");


           postMethod.setHeader(SOAP_ACTION, getSoapAction(soapAction));
           postMethod.setEntity(reqEntity);
           

           HttpResponse response = httpclient.execute(postMethod);
           
           

           int statusCode = response.getStatusLine().getStatusCode();
             
           if (statusCode == 200) {
               ResponseHandler<String> handler = new BasicResponseHandler();
               String resBody = handler.handleResponse(response);
               responseStr=resBody;
               

           } else {
           	System.out.println(statusCode);
             HttpEntity r_entity = response.getEntity(); // get response
               byte[] result = null;
               int statusCode1 = response.getStatusLine().getStatusCode();
               System.out.println("statusCode1"+statusCode1);
               if (r_entity != null &&r_entity.getContentLength()>0) {
                   result = new byte[(int) r_entity.getContentLength()];
                   if (r_entity.isStreaming()) {
                       DataInputStream is = new DataInputStream(r_entity.getContent());
                       is.readFully(result);
                      
                       String errorResponse = new String(result);
                       System.out.println("errorResponse"+errorResponse);
                       return errorResponse;
                    //   responseStr="";
                       


                   }
               }
           }
       } /*catch (UnsupportedEncodingException e) {

       } catch (ParseException e) {

       } catch (IOException e) {

       } */catch (Exception e) {
    	   System.out.println(e.toString());
       }


       return responseStr;
   }

}