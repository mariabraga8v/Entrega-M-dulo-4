package Controllers;

import java.io.IOException;

@WebServlet("/PedidoDelete")
public class PedidoDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PedidoDelete() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
