<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>

<style>
    form {
        display: flex;
        width: 300px;
        flex-direction: column;
        gap: 25px;
    }
</style>

<body>

<form action="processa_vaga" method="POST">

    <label>
        Name:
        <input type="text" name="name" required>
    </label>

    <label>
        Data Nasc:
        <input type="text" name="data_nasc">
    </label>

    <div>
        <div>Idioma nativo: </div>
        <input type="radio" name="idioma" value="PORTUGUES" checked> Português
        <input type="radio" name="idioma" value="ESPANHOL"> Espanhol
        <input type="radio" name="idioma" value="INGLES"> Inglês
    </div>

    <div>
        <div>Hability:  </div>
        <input type="checkbox" name="hability" value="JAVA" checked> Java
        <input type="checkbox" name="hability" value="JAVASCRIPT"> JavaScript
        <input type="checkbox" name="hability" value="HTML"> HTML
        <input type="checkbox" name="hability" value="CSS"> CSS
    </div>

    <input type="submit">

    <input type="reset">
</form>

</body>
</html>