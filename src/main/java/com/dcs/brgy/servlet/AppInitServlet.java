package com.dcs.brgy.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(
		  name = "appInitServlet",
		  description = "appInitServlet for application default values",
		  loadOnStartup = 1
		)
public class AppInitServlet extends HttpServlet {
	public static enum sex{
		MALE,
		FEMALE
	}
}
