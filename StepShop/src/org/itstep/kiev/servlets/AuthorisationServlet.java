package org.itstep.kiev.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.itstep.kiev.DAOLayer.CustomerDAO;
import org.itstep.kiev.domain.Customer;

import com.sun.org.apache.bcel.internal.generic.CASTORE;

@WebServlet("/authorisation")
public class AuthorisationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AuthorisationServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String login = request.getParameter("username");
		String password = request.getParameter("pass");
		
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
				
		Customer someCustomer = CustomerDAO.getCustomer(login, password);
		if(someCustomer.getLogin()==null){
			response.sendRedirect("loginErr.jsp");
		} else{
			if(someCustomer.getLogin().isEmpty()) {
				response.sendRedirect("loginErr.jsp");				
			}
			//response.sendRedirect("/jspClient/cabinetShop.jsp?username="+someCustomer.getName()+"&contact="+someCustomer.getContact());
			
		
			HttpSession session = request.getSession();
			session.setAttribute("username", someCustomer.getName());
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jspClient/cabinetShop.jsp");
			dispatcher.forward(request, response);
		
		}
		
		
		
		
	}

}


