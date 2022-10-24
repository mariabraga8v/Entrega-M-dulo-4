
import java.io.IOException;
import java.util.List;

import javax.security.sasl.SaslException;
import javax.xml.ws.WebServiceClient;

import dao.ClienteDao;
import model.Cliente;

@WebServiceClient("/CreateAndFind")
public class ClienteCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws SaslException, IOException {

		String pesquisa = request.getParameter("pesquisa");

		if (pesquisa == null) {
			pesquisa = "";
		}

		List<Cliente> clientes = ClienteDao.find(pesquisa);

		// Depois do cadastro retorna para pagina desejada no parametro.
		request.setAttribute("clientes", clientes);
		RequestDispatcher resquesDispatcher = request.getRequestDispatcher("listaCliente.jsp");// lista.jsp
		resquesDispatcher.forward(request, response);

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ClienteCreateAndFind []";
	}
}
