package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DestinoDAO;

/**
 * Servlet implementation class ExcluirDestinosServlet
 */
@WebServlet("/excluir")
public class ExcluirDestinosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idDestino = Integer.parseInt(request.getParameter("id"));
		
		DestinoDAO ddao = new DestinoDAO();
		ddao.remove(idDestino);
		response.sendRedirect("home");
	}


}
