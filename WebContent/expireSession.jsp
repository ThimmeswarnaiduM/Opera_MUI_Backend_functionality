<%@ page session="true" %>
<%
    // Invalidate session
    if (session != null) {
        session.invalidate();
    }

    // Redirect back to same page
    response.sendRedirect("NewInvoices.jsp");
%>
