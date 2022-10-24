package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;
import model.Cliente;

public class ClienteDao implements CrudCliente{
	
	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;
	
	
	public static void create(Cliente cliente) {
		sql = "INSERT into clientes VALUES(null,?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getCpf());
			preparedStatement.setString(3, cliente.getNascimento());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--Inserção correta no banco de dados");
			
		}catch(SQLException e){
			System.out.println("--Inserção incorreta no banco de dados" + e.getMessage());
			
		}
		
	}
	
	public static void delete(int ClienteId) {
		sql = "DELETE FROM clientes WHERE id= ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, ClienteId);
			preparedStatement.executeUpdate();
			
			System.out.println("--exclusão efetuada em cliente");
			
		}catch(SQLException e){
			
			System.out.println("--exclusão não efetuada em cliente"+ e.getMessage());
			
			
		}
		
		
	}
	
	public static List<Cliente> find(String pesquisa){
		
		sql = String.format("SELECT * FROM clientes WHERE nome LIKE '%s%%' OR cpf LIKE '%s%%' ", pesquisa,pesquisa);
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				Cliente cliente = new Cliente();
				
				cliente.setId(resultSet.getInt("id"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setCpf(resultSet.getString("cpf"));
				cliente.setNascimento(resultSet.getString("nascimento"));
				
				clientes.add(cliente);
						
			}
			System.out.println("--Clientes encontrados corretamente ");
			return clientes;
			
		}catch(SQLException e){
			System.out.println("--Incorrect fin clientes" + e.getMessage());
			return null;
			
		}
		
		
		
	}
	
	public static Cliente findByPk(int clienteId) {
		sql = String.format("SELECT * FROM clientes WHERE id= %d",clienteId);
				
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Cliente cliente = new Cliente();
			
			while(resultSet.next()) {
				
				cliente.setId(resultSet.getInt("id"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setCpf(resultSet.getString("cpf"));
				cliente.setNascimento(resultSet.getString("nascimento"));
				cliente.setSituacao(resultSet.getString("situacao"));
			}
			
			System.out.println("--Correct find by pk clientes. ");
			return cliente;
			
		}catch(SQLException e){
			
			System.out.println("--Incorrect fin clientes" + e.getMessage());
			return null;
			
		}
		
		
		
		
		
	}
	public static void update(Cliente cliente) {
		sql = "UPDATE clientes SET nome=?, cpf=?, nascimento=?, WHERE id=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getCpf());
			preparedStatement.setString(3, cliente.getNascimento());
			preparedStatement.setString(4, cliente.getSituacao());
			preparedStatement.setInt(5, cliente.getId());
			preparedStatement.executeUpdate();
			
			System.out.println("--atualização correta no banco de dados");
			
		}catch(SQLException e){
			System.out.println("--atualização incorreta no banco de dados" + e.getMessage());
			
		}
		
	}
	
	

}
