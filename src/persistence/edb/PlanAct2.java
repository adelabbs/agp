package persistence.edb;

import persistence.edb.operator.Operator;

public class PlanAct2 extends EDB_API {
	
	public PlanAct2(String tableName, String key, String userDirectoryPath) {
		super(tableName, key, userDirectoryPath);
	}

	@Override
	Operator executeMixedQuery(String query) {
		// TODO Auto-generated method stub
		return null;
	}

}
