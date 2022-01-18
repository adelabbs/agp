package persistence.edb;

import persistence.edb.operator.Operator;

public class ExectutionPlan2 extends EDB_API {
	
	public ExectutionPlan2(String tableName, String key, String userDirectoryPath) {
		super(tableName, key, userDirectoryPath);
	}

	@Override
	public Operator executeMixedQuery(String query) {
		// TODO Auto-generated method stub
		return null;
	}

}
