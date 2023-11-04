package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Destino;
import model.DestinoDAO;


@WebServlet("/Inserir")
public class InserirDestinosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public InserirDestinosServlet() {

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nomeDest");
		
		Destino objDestino = new Destino();
		
		objDestino.setNomeDest(nome);
		
		DestinoDAO ddao = new DestinoDAO();
		ddao.save(objDestino);
		
		response.sendRedirect("home");
		
	}

}
