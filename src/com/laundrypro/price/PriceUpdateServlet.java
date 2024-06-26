package com.laundrypro.price;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PriceUpdate
 */
@WebServlet("/PriceUpdate")
public class PriceUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String type = request.getParameter("type");
		// priceUtil Object to access methods
		IPriceUtil priceUtil = new PriceUtil();

		boolean doUpdate = false;

		// check type and update
		if (type.equals("bulk")) {

			double weight = Double.parseDouble(request.getParameter("weight"));
			double iprice = Double.parseDouble(request.getParameter("price"));
			int id = Integer.parseInt(request.getParameter("bid"));

			// call method to update
			doUpdate = priceUtil.updateBulkPrice(id, weight, iprice);

		} else if (type.equals("dry_clean")) {

			int id = Integer.parseInt(request.getParameter("dcid"));
			String iname = request.getParameter("iname");
			double iprice = Double.parseDouble(request.getParameter("iprice"));

			// call method to update
			doUpdate = priceUtil.updateDryCleanPrice(id, iname, iprice);

		}

		// redirection
		if (doUpdate == true) {

			response.sendRedirect(request.getContextPath() + "/retrievePrice");

		} else {

			response.sendRedirect(request.getContextPath() + "/retrievePrice");

		}

	}

}
