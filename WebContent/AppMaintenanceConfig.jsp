<%@page import="config.Configuration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title></title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<%
	String loginStatus = (String) request.getAttribute("loginStatus");
	if(loginStatus != null && loginStatus.equals("SUCCESS"))
	{
		String attrUpdate = (String) request.getAttribute("AttributeUpdate");
		if(attrUpdate != null && attrUpdate.equals("SUCCESS"))
		{
			%>
				<script type="text/javascript">
					alert("Updated Successfully");
				</script>
			<%
		} else if(attrUpdate != null && attrUpdate.equals("FAILED"))
		{
			%>
				<script type="text/javascript">
					alert("Update Failed");
				</script>
			<%
		}
	%>
		<!-- Updating Attributes -->
		<div class="container">
		  <form class="form-horizontal" action="UpdateAppContent?purpose=UPDATE" method="post">
		    <div class="form-group">
		      <label class="control-label col-sm-2">Maintenance Flag</label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" name="maintenance" value='<%=Configuration.underMaintainance%>'>
		      </div>
		    </div>
		    <div class="form-group">
		      <label class="control-label col-sm-2">Start Time</label>
		      <div class="col-sm-10">          
		        <input type="text" class="form-control" name="startTime" value='<%=Configuration.downtimeFrom%>'>
		      </div>
		    </div>
		    <div class="form-group">
		      <label class="control-label col-sm-2">End Time</label>
		      <div class="col-sm-10">          
		        <input type="text" class="form-control" name="endTime"  value='<%=Configuration.downtimeTo%>'>
		      </div>
		    </div>
		    <div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-default">Submit</button>
		      </div>
		    </div>
		  </form>
		</div>
		
		<%
	} else
	{
	%>

		<!-- Login -->
		<div class="container">
		  <form class="form-horizontal" action="UpdateAppContent?purpose=LOGIN" method="post">
		    <div class="form-group">
		      <label class="control-label col-sm-2">Username</label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" name="username">
		      </div>
		    </div>
		    <div class="form-group">
		      <label class="control-label col-sm-2">Password</label>
		      <div class="col-sm-10">          
		        <input type="password" class="form-control" name="password">
		      </div>
		    </div>
		    <div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-default">Submit</button>
		      </div>
		    </div>
		  </form>
		</div>

	<%
		}
	%>

</body>
</html>
