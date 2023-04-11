<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String name = (String) request.getAttribute("attr_name");
    LocalDate data = (LocalDate) request.getAttribute("attr_data");

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String dataFormatada = data.format(formatter);
    String idioma = (String) request.getAttribute("attr_idioma");
    String [] habilities = (String[]) request.getAttribute("attr_habilities");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Cadastro submetido!</h1>
    <ul>
        <li><% out.print(name); %></li>
        <li><% out.print(dataFormatada); %></li>
        <li><% out.print(idioma); %></li>
        <ul><% for (String hability : habilities) { %>
            <li><% out.print(hability); %></li>
            <% } %>
        </ul>
    </ul>
</body>
</html>
