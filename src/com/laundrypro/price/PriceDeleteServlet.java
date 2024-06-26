package com.laundrypro.price;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PriceDeleteServlet
 */
@WebServlet("/PriceDeleteServlet")
public class PriceDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		boolean doDelete = false;
		// priceUtil Object to access methods
		IPriceUtil priceUtil = new PriceUtil();
		String type = request.getParameter("type");

		// check type of price to delete
		if (type.equals("bulk")) {
			int id = Integer.parseInt(request.getParameter("bid"));

			doDelete = priceUtil.deleteBulkPrice(id); // method call

		} else if (type.equals("dry_clean")) {
			int id = Integer.parseInt(request.getParameter("dcid"));

			doDelete = priceUtil.deleteDryCleanPrice(id); // method call
		}

		// redirection
		if (doDelete == true) {

			response.sendRedirect(request.getContextPath() + "/retrievePrice");

		} else {

			response.sendRedirect(request.getContextPath() + "/retrievePrice");

		}
	}

}
