<%@ page import="edu.unbosque.Workshop4.lista" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.google.gson.Gson" %><%--
  Created by IntelliJ IDEA.
  User: santi
  Date: 29/04/2021
  Time: 5:26 p. m.
  To change this template use File | Settings | File Templates.
--%>
<html>

<head>
    <title>FORMULARIO2</title>
</head>
<body>

<table >
    <thead>
    <tr>

        <th>
            Nombre
        </th>
        <th>
            Comentario
        </th>
        <th>
            Fecha
        </th>
        <th>
            Imagen
        </th>
    </tr>
    </thead>
    <tbody id="res">

    </tbody>

</table>

<script>
    function mostrarMascota(servlet) {

        const xhr = new XMLHttpRequest();
        xhr.open('GET', '${pageContext.request.contextPath}/' + servlet, true);
        xhr.send();
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
                let data = JSON.parse(xhr.responseText);

                let res = document.querySelector('#res');

                res.innerHTML = "";
                for (let item of data) {
                    console.log(item)
                    res.innerHTML += '<tr>' +
                        '<td>' + item.name + '</td>' +
                        '<td>' + item.comentario + '</td>' +
                        '<td>' + item.date + '</td>' +
                        '<td>' + item.imagename + '</td>' + '</tr>'
                }

            }
        }
    }

    mostrarMascota(servlet = 'update')
</script>

</body>
</html>
