package persistence.edb;

import persistence.edb.operator.Operator;

public class PlanAct1 extends EDB_API {
	
	public PlanAct1(String tableName, String key, String userDirectoryPath) {
		super(tableName, key, userDirectoryPath);
	}

	Operator executeMixedQuery(String query) {
		return null;
	}

}
