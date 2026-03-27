package config;

import java.io.IOException;
import java.net.URLEncoder;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class TokenManager {
	  private static String authToken = "eyJ4NXQjUzI1NiI6IlUyRW1ORVkzbU04ekpLUFotWV9qeGVDbkR0dzJVYlNhQW9CZWpBN0F5dUUiLCJ4NXQiOiJfd0xEN0Z5MWJDUDlCRXFkcnVqbjFpLVctaWciLCJraWQiOiJTSUdOSU5HX0tFWSIsImFsZyI6IlJTMjU2In0.eyJjbGllbnRfb2NpZCI6Im9jaWQxLmRvbWFpbmFwcC5vYzEuYXAtbXVtYmFpLTEuYW1hYWFhYWFhcXRwNWJhYW95bnFtM2VyZWE1Z2x0ZW54cXdtNXdvZGU0Y3l1N2wzem9weXRxZGR3eWJxIiwidXNlcl90eiI6IkFtZXJpY2EvQ2hpY2FnbyIsInN1YiI6ImFiaGlrLmRhc0Bpbm5vdmFjeC5jb20iLCJ1c2VyX2xvY2FsZSI6ImVuIiwic2lkbGUiOjQ4MCwidXNlci50ZW5hbnQubmFtZSI6ImlkY3MtZTI2MGE0YmU5Njg0NGViZGEwNzYxZjFiNzQxNjY4YzUiLCJpc3MiOiJodHRwczovL2lkZW50aXR5Lm9yYWNsZWNsb3VkLmNvbS8iLCJkb21haW5faG9tZSI6ImFwLW11bWJhaS0xIiwiY2Ffb2NpZCI6Im9jaWQxLnRlbmFuY3kub2MxLi5hYWFhYWFhYTJ6M2ZmeHF5NGMzcHB0MmY1bml3MzJkYjM2d21jNnRnNjdicXFkeGtpMnR3bjczcXQzYmEiLCJ1c2VyX3RlbmFudG5hbWUiOiJpZGNzLWUyNjBhNGJlOTY4NDRlYmRhMDc2MWYxYjc0MTY2OGM1IiwiY2xpZW50X2lkIjoiQ1hVTklUWVNJLWloY2xjZHB0ZXN0X0FQUElEIiwiZG9tYWluX2lkIjoib2NpZDEuZG9tYWluLm9jMS4uYWFhYWFhYWE3cjdxdjV2aXc1Zmx3ZmVnNWR6YXVhdHhseWV4aG53Nml6amVlcXp1NXNxczRzYmNwNHpxIiwic3ViX3R5cGUiOiJ1c2VyIiwic2NvcGUiOiJjeHVuaXR5IiwidXNlcl9vY2lkIjoib2NpZDEudXNlci5vYzEuLmFhYWFhYWFhcmFmcWJpbXk0YjVjdWpxcm80dGV5czZ2dGo2NnZ4MnZrd2phenY1b2EzcWg0NG1kYXZwcSIsImNsaWVudF90ZW5hbnRuYW1lIjoiaWRjcy1lMjYwYTRiZTk2ODQ0ZWJkYTA3NjFmMWI3NDE2NjhjNSIsInJlZ2lvbl9uYW1lIjoiYXAtbXVtYmFpLWlkY3MtMSIsInVzZXJfbGFuZyI6ImVuIiwiZXhwIjoxNzYzNTM3MTgwLCJpYXQiOjE3NjM1MzM1ODAsImNsaWVudF9ndWlkIjoiNDk5M2ZmNWEyM2UwNDBlOGJhZjQzYTYxNTUyNzNkYWEiLCJjbGllbnRfbmFtZSI6IkNYVU5JVFlTSS1paGNsY2RwdGVzdCIsInRlbmFudCI6ImlkY3MtZTI2MGE0YmU5Njg0NGViZGEwNzYxZjFiNzQxNjY4YzUiLCJqdGkiOiIwOTE2YTZlYmQ4MDM0MmYzYmYxZDQxYzM3MjY4OTIxZCIsImd0cCI6InJvIiwidXNlcl9kaXNwbGF5bmFtZSI6IkFiaGlrIERhcyIsIm9wYyI6dHJ1ZSwic3ViX21hcHBpbmdhdHRyIjoidXNlck5hbWUiLCJwcmltVGVuYW50Ijp0cnVlLCJ0b2tfdHlwZSI6IkFUIiwiYXVkIjpbInVybjpvcGM6ZW50aXRsZW1lbnRpZD1paGNsY2RwdGVzdCIsImh0dHBzOi8vaWhjbGNkcHRlc3QuY3h1bml0eS5vY3Mub3JhY2xlY2xvdWQuY29tLyJdLCJjYV9uYW1lIjoiaWhjbGNkcCIsInN0dSI6IkNYVU5JVFkiLCJ1c2VyX2lkIjoiNzkyNmM5NmIzMzdiNDliMTkxOTk3MDNlYWU0NWJiODYiLCJkb21haW4iOiJEZWZhdWx0IiwidGVuYW50X2lzcyI6Imh0dHBzOi8vaWRjcy1lMjYwYTRiZTk2ODQ0ZWJkYTA3NjFmMWI3NDE2NjhjNS5pZGVudGl0eS5vcmFjbGVjbG91ZC5jb206NDQzIiwicmVzb3VyY2VfYXBwX2lkIjoiNDk5M2ZmNWEyM2UwNDBlOGJhZjQzYTYxNTUyNzNkYWEifQ.i3t63p9-rdNE5bkAXSDcL648gJrKrHEYbb19_GKxuPVrxNWMtQrfSgsiBFTc_mQjKev4Vrvrr4fP7AlxY4eZUBGctrTA0PspQ6zG8P1kBW15_3HD4AZZwL875T3eTUNFVw_MGzjMQL92riUyHIh8NHJu-o3kTk1yumcahHhmpUYB8qArKuLhL1XPO5-bxhaRiNVJmCXCohqeMoXACguiD9OTyWtZDqgSp71MJldXwhLUwOH4RS2BpW5bOJYDahddwdVmdI9bDljimy26TlRTsLnraGMlVk5Y3ZRxTM8euk8woiiUsXMa27DUpt_ecMt4APIbrV32oYXfqKGZ6jI1Cg"
;
	  
	  public static String getToken() {
	        return authToken;
	    }

	    
	    public static void setToken(String token) {
	        authToken = token;
	        System.out.println(authToken);
	    }
	    
	    public static String generateNewToken() throws IOException {

		    String newToken = null;
		    OkHttpClient client = new OkHttpClient();
		    Response response = null;

		    try {
		        String formData = "username=" + URLEncoder.encode("abhik.das@innovacx.com", "UTF-8") +
		                          "&password=" + URLEncoder.encode("Innovacx@1234", "UTF-8") +
		                          "&grant_type=password" +
		                          "&scope=" + URLEncoder.encode("urn:opc:entitlementid=ihclcdptestcxunity", "UTF-8");

		        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		        RequestBody body = RequestBody.create(mediaType, formData);

		        Request request = new Request.Builder()
		                .url("https://idcs-e260a4be96844ebda0761f1b741668c5.identity.oraclecloud.com/oauth2/v1/token")
		                .post(body)
		                .addHeader("Content-Type", "application/x-www-form-urlencoded")
		                .addHeader("Authorization", "Basic Q1hVTklUWVNJLWloY2xjZHB0ZXN0X0FQUElEOmlkY3Njcy0zNGI3ODE5My03NzM5LTQ3YTUtYTA4Yy1hZDBlYzY5YjVkNTA=")
		                .build();

		        response = client.newCall(request).execute();

		        int statusCode = response.code();
		        System.out.println("Response Code: " + statusCode);

		        if (response.isSuccessful()) {
		            String responseBody = response.body().string();
		            System.out.println("Token Response: " + responseBody);
		            newToken = extractTokenFromResponse(responseBody);
		        } else {
		            System.out.println("Failed: " + response.body().string());
		        }

		    } catch (Exception e) {
		        System.err.println("Error generating token: " + e.getMessage());
		        e.printStackTrace();

		    } finally {
		        if (response != null) {
		            response.body().close();  // Important to prevent connection leaks
		        }
		    }

		    return newToken;
		}
	    private static String extractTokenFromResponse(String responseBody) {
		    String token = responseBody.split("\"access_token\":\"")[1].split("\"")[0];
		    return token;
		  }
		  
	    
	    

}
