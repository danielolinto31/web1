package br.unirn.exemplos.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author Daniel Olinto
 * @since 29/03/2014 Implementando a class LoginServlet - UNIRN
 * 
 */

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session != null) {
			String operacao = request.getParameter("operacao");
			if (operacao.equals("logout")) {
				/* Destroe a sessao ativa */
				request.getSession().invalidate();
				response.sendRedirect("/");
			}
		} else {

			PrintWriter out = response.getWriter();

			out.write("<html>");
			out.write("<head>");
			out.write("<meta charset='ISO-8859-1'>");
			out.write("<title>WEB I - Daniel Olinto</title>");
			out.write("<link rel='stylesheet' type='text/css' href='/web1/css/style.css'>");
			out.write("</head>");
			out.write("<body>");
			out.write("<div id='wrapper'>");
			out.write("<h1>Acesso indevido, faça o login!</h1>");
			out.println(new Date());
			out.write("</div>");
			out.write("</body>");
			out.write("</html>");

			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String operacao = request.getParameter("operacao");

		if (operacao.equals("logar")) {

			String login = request.getParameter("login");
			String senha = request.getParameter("senha");

			if (login.equals("admin") && senha.equals("12345")) {
				HttpSession session = request.getSession(true);

				session.setAttribute("usuarioLogado", login);

				loginComSucesso(request, response);

			} else {
				loginSemSucesso(response);
			}

		} else if (operacao.equals("logout")) {
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
			}
			response.sendRedirect(request.getContextPath() + "/");
		}

	}

	private void loginSemSucesso(HttpServletResponse response)
			throws IOException {
		PrintWriter out = response.getWriter();

		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset='ISO-8859-1'>");
		out.write("<title>WEB I - Daniel Olinto</title>");
		out.write("<link rel='stylesheet' type='text/css' href='/web1/css/style.css'>");
		out.write("</head>");
		out.write("<body>");
		out.write("<div id='wrapper'>");
		out.write("<h1>Usuário e/ou Senha Incorreto(os)</h1>");
		out.println(new Date());
		out.write("</div>");
		out.write("</body>");
		out.write("</html>");

		out.close();

	}

	private void loginComSucesso(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		request.getRequestDispatcher("/sistema/menu.html").forward(request,
				response);

	}

}
