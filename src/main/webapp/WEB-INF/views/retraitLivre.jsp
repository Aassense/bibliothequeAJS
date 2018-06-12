<%@page import="bibliothequeAJS.service.Transfert"%>
<%@page import="bibliothequeAJS.service.Livre"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
table {
    border-collapse: collapse;
    border-spacing: 0;
    width: 100%;
    border: 1px solid #ddd;
}

th {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}
</style>
<title>Retrait du livre</title>
</head>
<body>
<h1>Retrait du livre.</h1>
<h2>Cliquer sur Retrait pour transférer le livre.</h2>
<table>
    <tr>
      <th>Titre</th>
      <th>Date</th>
      <th>Auteur</th>
      <th>Editeur</th>
    </tr>
    <tr>
      <th>${livre.titre}</th>
      <th>${livre.annee}</th>
      <th>${livre.auteur}</th>
      <th>${livre.editeur}</th>
    <tr>
</table>
<a href="/bibliothequeIAA/retrait/${livre.id}">Retrait</a>



</body>
</html>