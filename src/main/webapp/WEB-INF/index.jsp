<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
table {
    border-collapse: collapse;
    border-spacing: 0;
    width: 100%;
    border: 1px solid #ddd;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}
</style>
</head>
<body>

<h2>AJS Library</h2>
<p>Bienvenue dans notre bibliothèque</p>
<p>Cliquez sur un ouvrage pour le voir</p>

<div style="overflow-x:auto;">
  <table>
    <tr>
      <th>Titre</th>
      <th>Date</th>
      <th>Auteur</th>
      <th>Editeur</th>
    </tr>
    <tr>
      <td>bla</td>
      <td>bli</td>
      <td>1950</td>
      <td>blu</td>
    </tr>
    <tr>
      <td>ga</td>
      <td>bu</td>
      <td>1940</td>
      <td>zo</td>
    </tr>
    <tr>
      <td>pim</td>
      <td>pam</td>
      <td>1670</td>
      <td>poum</td>
    </tr>
  </table>
</div>

</body>
</html>
