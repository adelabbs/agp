package persistence.edb;

import persistence.edb.operator.Operator;

public class ExecutionPlan1 extends EDB_API {
	
	public ExecutionPlan1(String tableName, String key, String userDirectoryPath) {
		super(tableName, key, userDirectoryPath);
	}

	public Operator executeMixedQuery(String query) {
		return null;
	}

}
