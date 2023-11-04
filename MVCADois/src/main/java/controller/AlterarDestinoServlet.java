package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Destino;
import model.DestinoDAO;

/**
 * Servlet implementation class AlterarDestinoServlet
 */
@WebServlet("/editar")
public class AlterarDestinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idDes = Integer.parseInt(request.getParameter("id"));
		DestinoDAO ddao = new DestinoDAO();
		Destino destinoSelecionado = ddao.getContado(idDes);
		
		request.setAttribute("destino", destinoSelecionado);
		
		RequestDispatcher rd = request.getRequestDispatcher("/alterarDestino.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Destino objDestino = new Destino();
		
		objDestino.setNomeDest(request.getParameter("nome"));
		objDestino.setIdDes(Integer.parseInt(request.getParameter("id")));
		
		DestinoDAO ddao = new DestinoDAO();
		ddao.update(objDestino);
		
		response.sendRedirect("home");
	}

}
