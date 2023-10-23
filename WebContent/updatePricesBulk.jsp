<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Bulk Prices</title>
</head>
<body>
	<!--main content-->
	<main class="main">
		<div id="main-content">

			<%
			String weight = request.getParameter("weight");
			String price = request.getParameter("kgprice");
			String id = request.getParameter("bid");
			%>


			<form class="price-form" method="post" action="priceUpdate">

				<input type="hidden" name="type" value="bulk">
				<!-- hidden field to help decide which method to execute -->
				<input type="hidden" name="bid" value="<%=id%>" />
				
				<label>Weight(in kilos)</label>
				<input type="text" inputmode="numeric" name="weight" value="<%=weight%>" />
				<br />
				<label>Item price(rs)</label>
				<input type="text" inputmode="numeric" name="price" value="<%=price%>" />
				<br />
				<input type="submit" value="update" />
			</form>
		</div>
	</main>
</body>
</html>