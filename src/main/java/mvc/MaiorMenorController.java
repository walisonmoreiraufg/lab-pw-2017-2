package mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/MaiorMenorController")
public class MaiorMenorController extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		//Obt�m os par�metros da requisi��o.
		String idadeString = request.getParameter("idade");
		int idade = idadeString == null ? 0 : Integer.parseInt(idadeString);
		
		//Executa a regra de neg�cio.
		String resultado =
				MaiorMenorModel.descricaoDaMaioridade(idade);
		
		//Chama a view.
		//Mandar mensagem para o JSP mostrar.
		request.setAttribute("resultado", resultado);
		request.getRequestDispatcher("mvc/MaiorMenorView.jsp").forward(request, response);
	}
}
