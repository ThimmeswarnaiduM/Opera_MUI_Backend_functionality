package config;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.DataInputStream;
import java.io.UnsupportedEncodingException;



public class SoapExecutor1 {



    private static final String CONTENT_TYPE = "text/xml;charset=UTF-8";
    private static final String SOAP_ACTION = "SOAPAction";

    private String endPointUrl;
    private HttpHost proxy = null;

    public SoapExecutor1(String endPointURL) {
        /*if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }*/
        this.endPointUrl = endPointURL;
    }

    public SoapExecutor1(String endPointURL, String host, int port)
    {
        this(endPointURL);
        this.proxy = new HttpHost(host, port);
    }


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
            // reqEntity = new StringEntity(reqXML, "text/xml", "utf-8");


            postMethod.setHeader(SOAP_ACTION, getSoapAction(soapAction));
            postMethod.setEntity(reqEntity);
            postMethod.addHeader(new BasicScheme().authenticate(new UsernamePasswordCredentials(userName, password), postMethod));

            HttpResponse response = httpclient.execute(postMethod);


            int statusCode = response.getStatusLine().getStatusCode();
           System.out.println("Status : "+statusCode);
            if (statusCode == 200) {
                ResponseHandler<String> handler = new BasicResponseHandler();
                String resBody = handler.handleResponse(response);
                responseStr=resBody;
                //System.out.println("tanh : "+responseStr);
                //System.out.println(resBody);

            } else {

                HttpEntity r_entity = response.getEntity(); // get response
                byte[] result = null;
                if (r_entity != null &&r_entity.getContentLength()>0) {
                    result = new byte[(int) r_entity.getContentLength()];
                    if (r_entity.isStreaming()) {
                        DataInputStream is = new DataInputStream(r_entity.getContent());
                        is.readFully(result);
                        String errorResponse = new String(result);
                        responseStr=errorResponse;


                    }
                }
            }
        } catch (UnsupportedEncodingException e) {
        	System.out.println(e);
            //Log.d("Response","UnsupportedEncodingException"+e);

        } 
        catch (Exception e) {
        	System.out.println(e);
        }
        //System.out.println("Response : "+responseStr);
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


}