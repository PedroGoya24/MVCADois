package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Destino;
import model.DestinoDAO;


@WebServlet("/home")
public class ListarDestinosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Destino> destinos = new ArrayList<Destino>();
		DestinoDAO ddao = new DestinoDAO();
		destinos = ddao.getDestinos();
		request.setAttribute("listaDestinos", destinos);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastroDestino.jsp");
		dispatcher.forward(request, response);
	}


}
