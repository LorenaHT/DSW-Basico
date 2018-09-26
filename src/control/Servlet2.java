package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest peticion, HttpServletResponse respuesta) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String op1 = peticion.getParameter("a");
		String op2 = peticion.getParameter("b");
		int suma = 0;
		try {
			suma = Integer.parseInt(op1) + Integer.parseInt(op2);
			respuesta.getWriter().append(" La suma es " + suma);
		} catch (NumberFormatException e) {
			respuesta.getWriter().append(" Error de formato en operando");
		}
		String contextoParam = this.getServletContext().getInitParameter("Pais");
		System.out.println(contextoParam);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
