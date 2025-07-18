package com.bookmyrestaurant.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmyrestaurant.service.MenuService;
import com.bookmyrestaurant.service.MenuServiceImpl;

/*
	DELETE MENU ITEM USING THE ID
	SEND THE RESP LIST TO MENUDASH
*/

@WebServlet("/deletemenu")
public class MenuServlet4 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int menuItemId=Integer.parseInt(req.getParameter("id"));
		MenuService menuService=new MenuServiceImpl();
		boolean status=menuService.deleteMenuItem(menuItemId);
		if(status) {
			RequestDispatcher rd=req.getRequestDispatcher("/menu");
			rd.forward(req, resp);
		}
	}
}
