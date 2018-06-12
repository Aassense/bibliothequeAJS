<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">

<head>
<title>Bibliothèque AJS</title>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>

<body>
	<c:if test="${ !message.isEmpty() }">
		<div class="container">
			<p>${message }</p>
		</div>
	</c:if>

	<div class="limiter">

		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100 ver5 m-b-110">
					<table data-vertable="ver5">
						<thead>
							<tr class="row100 head">
								<th class="column100 column1" data-column="column1">Titre</th>
								<th class="column100 column2" data-column="column2">Date</th>
								<th class="column100 column3" data-column="column3">Auteur</th>
								<th class="column100 column4" data-column="column4">Editeur</th>
							</tr>
						</thead>

						<tbody>

							<c:forEach items="${livres}" var="livre" varStatus="indexListe">
								<tr class="row100">
									<td class="column100 column1" data-column="column1"><a
										href="/getLivre/${indexListe.count}"><c:out
												value="${livre.titre}" /></a></td>
									<td class="column100 column2" data-column="column2"><a
										href="/getLivre/${indexListe.count}"><c:out
												value="${livre.annee}" /></a></td>
									<td class="column100 column3" data-column="column3"><a
										href="/getLivre/${indexListe.count}"><c:out
												value="${livre.auteur}" /></a></td>
									<td class="column100 column4" data-column="column4"><a
										href="/getLivre/${indexListe.count}"><c:out
												value="${livre.editeur}" /></a></td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>




	<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>