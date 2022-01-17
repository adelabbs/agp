package persistence.edb.operator;

import persistence.jdbc.JdbcConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLOperator extends Operator {

	public void executeQuery(String query) {
		try {
			PreparedStatement preparedStatement = JdbcConnection.getConnection().prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			preparedStatement.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

}
