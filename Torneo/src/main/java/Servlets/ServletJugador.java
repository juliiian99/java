package Servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Datos.DataJugador;
import Datos.DataPais;
import Entidades.Encrypt;
import Entidades.Jugador;
import Entidades.Pais;

/**
 * Servlet implementation class ServletJugador
 */
@WebServlet("/ServletJugador")
public class ServletJugador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletJugador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LinkedList<Jugador> data = new LinkedList<Jugador>(); 
		data = DataJugador.list();
		request.setAttribute("data", data);
		getServletContext().getRequestDispatcher("/jsp/Jugador.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(		request.getParameter("usuarioNuevo") != null
				&& request.getParameter("nombreNuevo") != null
				&& request.getParameter("apellidoNuevo") != null 
				&& request.getParameter("paisNuevo") != null
				&& request.getParameter("contrase�aNuevo") != null
				&& request.getParameter("accesoNuevo") != null) {
			Pais p = new Pais();
			String usuario = request.getParameter("usuarioNuevo");
			String nombre = request.getParameter("nombreNuevo");
			String apellido = request.getParameter("apellidoNuevo");
			String pais = request.getParameter("paisNuevo");
			String acceso = request.getParameter("accesoNuevo");
			String contrase�a = Encrypt.convertirSHA256(request.getParameter("contrase�aNuevo")); 
			p = DataPais.search(pais);
			DataJugador.create(usuario, contrase�a , nombre, apellido, acceso ,p.getId());
			doGet(request, response);
		}
		if  (	request.getParameter("usuarioActualizar") != null
				&& request.getParameter("nombreActualizar") != null
				&& request.getParameter("apellidoActualizar") != null 
				&& request.getParameter("paisActualizar") != null
				&& request.getParameter("contrase�aActualizar") != null
				&& request.getParameter("idActualizar") != null
				&& request.getParameter("accesoActualizar") != null
				&& request.getParameter("reportesActualizar") != null){
			Pais p = new Pais();
			int idJug = Integer.parseInt(request.getParameter("idActualizar"));
			String usuario = request.getParameter("usuarioActualizar");
			String nombre = request.getParameter("nombreActualizar");
			String apellido = request.getParameter("apellidoActualizar");
			String acceso = request.getParameter("accesoActualizar");
			String pais = request.getParameter("paisActualizar");
			String contrase�a = Encrypt.convertirSHA256(request.getParameter("contrase�aActualizar"));
			int cantReportes = Integer.parseInt(request.getParameter("reportesActualizar"));
			p.setNombre(pais);
			p = DataPais.buscar(p);
			DataJugador.update(idJug, usuario, contrase�a, nombre, apellido, acceso, p, cantReportes);
			doGet(request, response);
		}
		if(	request.getParameter("usuarioEliminar") != null){
			String usuario = request.getParameter("usuarioEliminar");
			DataJugador.delete(usuario);
			doGet(request, response);
		}
	}

}