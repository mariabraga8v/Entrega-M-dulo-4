
import java.io.IOException;

import javax.security.sasl.SaslException;
import javax.xml.ws.WebServiceClient;

import Controllers.HttpServlet;
import dao.ClienteDao;

@WebServiceClient("/ClienteDestroy")
public class ClienteDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/* ====== Apaga um cliente cadastrado pelo id ====== */
	/**
	 * 
	 */
	public ClienteDelete() {
		super();
	}

	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int clienteId = Integer.parseInt(request.getParameter("Idcliente"));
		ClienteDao.delete(clienteId);

		ClienteCreateAndFind clienteCreateAndFind = new ClienteCreateAndFind();
		extracted(request, response, clienteCreateAndFind);

	}

	private void extracted(HttpServletRequest request, HttpServletResponse response,
			ClienteCreateAndFind clienteCreateAndFind) throws SaslException, IOException {
		clienteCreateAndFind.doGet(request, response);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ClienteDelete []";
	}

	@Override
	protected void doPost(Controllers.ClienteCreateAndFind clienteCreateAndFind, HttpServlet response)
			throws IOException {
		// TODO Auto-generated method stub
		super.doPost(clienteCreateAndFind, response);
	}

}
