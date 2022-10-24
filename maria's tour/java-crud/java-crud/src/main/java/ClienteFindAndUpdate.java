
import java.io.IOException;

import javax.jws.WebService;

import Controllers.ClienteCreateAndFind;
import Controllers.HttpServlet;
import Controllers.HttpServletRequest;
import dao.ClienteDao;
import model.Cliente;

@WebService("/ClienteUpdate")
public class ClienteFindAndUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ClienteFindAndUpdate() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/* ===== Search for a customer by id. ====== */
		int clienteId = Integer.parseInt(request.getParameter("clienteId"));
		Cliente cliente = ClienteDao.findByPk(clienteId);

		request.setAttribute("cliente", cliente);
		RequestDispatcher resquesDispatcher = request.getRequestDispatcher("formUpdateCliente.jsp");
		resquesDispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/* ====== Update client data ===== */
		Cliente cliente = new Cliente();

		cliente.setId(Integer.parseInt(request.getParameter("id")));
		cliente.setNome(request.getParameter("nome"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setNascimento(request.getParameter("nascimento"));
		cliente.setSituacao(request.getParameter("situacao"));

		ClienteDao.update(cliente);
		ClienteCreateAndFind clienteCreateAndFind = new ClienteCreateAndFind();
		clienteCreateAndFind.doGet(request, response);

	}

	@Override
	public String toString() {
		return "ClienteFindAndUpdate []";
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
