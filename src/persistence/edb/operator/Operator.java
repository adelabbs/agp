package persistence.edb.operator;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Operator {
	
	ResultSet resultSet = null;
	private int cpt;
	private int numberOfRows;
	
	public void init() {
		try {
			numberOfRows = resultSet.getRow();
			cpt = 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Result next() {
		try {
			//return result.next();
			resultSet.getObject(0);
			resultSet.getArray(cpt);
			cpt++;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public abstract void executeQuery(String query);
	
}
