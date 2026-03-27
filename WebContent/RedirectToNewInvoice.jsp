<!doctype html>
<html>
	<head>
		<script src="importedLib/jquery-3.3.1.min.js"></script>
		<script>

		Util = {
				redirectToReservUrl :	function(Url, ReservId, Property, flag){
					$(document).ready(function(){
						var formHtml = '<form action="'+Url+'" method="POST">'+
					    		'<input type="hidden" name="ReservId" value="'+ReservId+'">'+
					    		'<input type="hidden" name="Property" value="'+Property+'">';

						// Add flag parameter if provided
						if(flag != null && flag != '' && flag != 'null') {
							formHtml += '<input type="hidden" name="flag" value="'+flag+'">';
						}

						formHtml += '</form>';
						$(formHtml).appendTo('body').submit();
						});
					}
			}
		</script>
	</head>
	<body>
	<%
		 String ResId = request.getParameter("ReservId");
		 String URLPropertyCode = request.getParameter("Property");
		 if(ResId == null || ResId.trim().equalsIgnoreCase("") || URLPropertyCode == null || URLPropertyCode.trim().equalsIgnoreCase(""))
		 {
			 %>
				<script type="text/javascript">
					window.location="NoReservation.jsp";
				</script>
			<%
			return;
		 }
	%>
	<script> Util.redirectToReservUrl("NewInvoices.jsp",'<%=request.getParameter("ReservId")%>','<%=request.getParameter("Property")%>','<%=request.getParameter("flag")%>')</script>
	</body>
</html>