<%@page import="data.HashMapData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>

<h3>HashMap Count</h3>
<table>
	<tr>
		<td>mapCurrency</td><td><%=HashMapData.mapCurrency.size() %></td>
	</tr>
	<tr>
		<td>mapCurrencyCode</td><td><%=HashMapData.mapCurrencyCode.size() %></td>
	</tr>
	<tr>
		<td>mapMemberData</td><td><%=HashMapData.mapMemberData.size() %></td>
	</tr>
	<tr>
		<td>mapProfileData</td><td><%=HashMapData.mapProfileData.size() %></td>
	</tr>
	<tr>
		<td>mapReservationData</td><td><%=HashMapData.mapReservationData.size() %></td>
	</tr>
	<tr>
		<td>mapInvoiceData</td><td><%=HashMapData.mapInvoiceData.size() %></td>
	</tr>
	<tr>
		<td>mapInvoices</td><td><%=HashMapData.mapInvoices.size() %></td>
	</tr>
	<tr>
		<td>mapProcessInvoices</td><td><%=HashMapData.mapProcessInvoices.size() %></td>
	</tr>
	<tr>
		<td>mapNewInvoices</td><td><%=HashMapData.mapNewInvoices.size() %></td>
	</tr>
	<tr>
		<td>mapGiftCard</td><td><%=HashMapData.mapGiftCard.size() %></td>
	</tr>
	<tr>
		<td>mapVoucher</td><td><%=HashMapData.mapVoucher.size() %></td>
	</tr>
	<tr>
		<td>mapHotels</td><td><%=HashMapData.mapHotels.size() %></td>
	</tr>
	<tr>
		<td>mapGcHotelsMap</td><td><%=HashMapData.mapGcHotelsMap.size() %></td>
	</tr>
</table>

<br/>
<br/>



</body>
</html>