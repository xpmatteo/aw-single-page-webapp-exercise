package it.xpug.example.main;


import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import static java.lang.String.*;

public class ExampleServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doTempConversion(request, response);
	}

	private void doTempConversion(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String celsiusAsString = request.getParameter("celsius");
		String json;
		if (celsiusAsString == null) {
			json = "{}";
		} else {
			double celsius = Double.valueOf(celsiusAsString);
			double fahrenheit = celsius * 9/5.0 + 32;
			Map<String, Object> values = new HashMap<String, Object>();
			values.put("celsius", celsius);
			values.put("fahrenheit", fahrenheit);
			json = mapToJson(values);
			json = format("{ \"celsius\": %s, \"fahrenheit\": %s }", celsius, fahrenheit);
		}
		response.setContentType("application/json");
		response.getWriter().write(json);
	}

	private String mapToJson(Map<String, Object> values) {
		return null;
	}
}
