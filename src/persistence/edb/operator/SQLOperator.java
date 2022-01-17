package persistence.edb.operator;

import persistence.jdbc.JdbcConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSetMetaData;

public class SQLOperator implements Operator {
	
	private ResultSet resultSet;
	private ResultSetMetaData rsmd;
	private int numberOfColumns;
	private ArrayList<String> columnNames = new ArrayList<String>();
	
	@Override
	public void init() {
		try {
			resultSet.beforeFirst();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Result next() {
		Result result = new Result();
		try {
			if(resultSet.next()) {
				for(int i = 0; i < numberOfColumns; i++) {
					result.addField(columnNames.get(i), resultSet.getObject(i));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void buildResultMetaData() {
		try {
			rsmd = (ResultSetMetaData) resultSet.getMetaData();
			numberOfColumns = rsmd.getColumnCount();
			
			for(int i = 0; i < numberOfColumns; i++) {
				columnNames.add(rsmd.getColumnName(i));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
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
