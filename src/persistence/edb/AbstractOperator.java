package persistence.edb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface AbstractOperator {
	void init();
	AbstractOperator next();	
}
