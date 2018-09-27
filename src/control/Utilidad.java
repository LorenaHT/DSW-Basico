package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Utilidad
 */
//@WebServlet(urlPatterns = "/servlets/suma", initParams = { @WebInitParam(name = "nombre", value = "Mauricio"), })
public class Utilidad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Utilidad() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest peticion, HttpServletResponse respuesta)
			throws ServletException, IOException {
		HttpSession sesion = peticion.getSession();
		ArrayList<Object> lista = new ArrayList<Object>();
		if (sesion.getAttribute("lista") == null)
			sesion.setAttribute("lista", lista);
		if (sesion.getAttribute("usuario") == null)
			sesion.setAttribute("usuario", "mauricio");
		System.out.println("ID SESION : " + sesion.getId());
		Cookie[] cookies = peticion.getCookies();
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName() + " : " + cookie.getValue());
		}
		this.getServletContext().getRequestDispatcher("/Servlet2").forward(peticion, respuesta);;
		System.out.println("ESTOY EN UTILIDAD...");
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
		String paramConfig = this.getServletConfig().getInitParameter("nombre");
		System.out.println(paramConfig);
		String contextoConfig = this.getServletContext().getInitParameter("Pais");
		System.out.println(contextoConfig);
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("Inicializando servlet...!");

	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		System.out.println(config.getInitParameter("nombre"));

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
