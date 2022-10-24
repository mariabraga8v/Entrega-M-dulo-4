package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import db.MySqlConnection;
//import model.Cliente;
import model.Pedido;

public class PedidoDao implements CrudPedido{
	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;
	
	
	public static void create(Pedido pedido) {
		sql = "INSERT INTO pedido VALUES(null,?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(2, pedido.getcpfCliente());
			preparedStatement.setString(3, pedido.getIdViagem());
			preparedStatement.setString(4, pedido.getDataIda());
			preparedStatement.setString(5, pedido.getDataVolta());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--Correct insert on database");
			
		}catch(SQLException e){
			System.out.println("--Incorrect insert on database" + e.getMessage());
			
		}
		
	}
	
	public static void delete(int PedidoId) {
		sql = "DELETE FROM pedido WHERE id= ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, PedidoId);
			preparedStatement.executeUpdate();
			
			System.out.println("--correct delete on request");
			
		}catch(SQLException e){
			
			System.out.println("--incorrect delete on request"+ e.getMessage());
			
			
		}
		
		
	}
	
	/*SELECT ALL REQUEST*/
	public static List<Pedido> find(String pesquisa){
		
		sql = String.format("SELECT * FROM pedido WHERE idCliente LIKE '%s%%' ",pesquisa);
		List<Pedido> pedido = new ArrayList<Pedido>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				Pedido pedidos = new Pedido();
				
				pedidos.setId(resultSet.getInt("id"));
				pedidos.setQuantidade(resultSet.getString("cpfcliente"));
				pedidos.setIdProduto(resultSet.getString("idViagem"));
				pedidos.setDataPedido(resultSet.getString("dataIda"));
				pedidos.setDataViagem(resultSet.getString("dataVolta"));
				
				pedido.add(pedidos);
						
			}
			System.out.println("--Correct find requests. ");
			return pedido;
			
		}catch(SQLException e){
			System.out.println("--Incorrect find requests" + e.getMessage());
			return null;
			
		}
		
		
	}
	
	/*=====PESQUISA POR ID DO PEDIDO=====*/
	public static Pedido findByPk(int pedidoId) {
		sql = String.format("SELECT * FROM pedido WHERE id= %d",pedidoId);
				
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Pedido pedido = new Pedido();
			
			while(resultSet.next()) {
				
				pedido.setId(resultSet.getInt("id"));
				pedido.setQuantidade(resultSet.getString("cpfclieente"));
				pedido.setIdProduto(resultSet.getString("idProduto"));
				pedido.setDataPedido(resultSet.getString("dataida"));
				pedido.setDataViagem(resultSet.getString("dataVolta"));
			}
			
			System.out.println("--Correct find by pk request. ");
			return pedido;
			
		}catch(SQLException e){
			
			System.out.println("--Incorrect find request" + e.getMessage());
			return null;
			
		}		
		
		
	}
	
	/*=====UPDATE da solicitação de viagem=====*/
	public static void update(Pedido pedido) {
		sql = "UPDATE pedido SET cpfcliente=?, idviagem=?, dataVolta=? WHERE id=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, pedido.getcpfcliente());
			preparedStatement.setString(2, pedido.getidviagem());
			preparedStatement.setString(3, pedido.getdataVolta());
			preparedStatement.setInt(4, pedido.getId());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--Correct update on database");
			
		}catch(SQLException e){
			System.out.println("--Incorrect update on database" + e.getMessage());
			
		}
		
	}
	

}
