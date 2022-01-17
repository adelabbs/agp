package persistence.edb.operator;

import persistence.jdbc.JdbcConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLOperator implements Operator {
	
	private ResultSet resultSet;
	
	public void executeQuery(String query) {
		try {
			PreparedStatement preparedStatement = JdbcConnection.getConnection().prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			preparedStatement.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Result next() {
		// TODO Auto-generated method stub
		return null;
	}

}
