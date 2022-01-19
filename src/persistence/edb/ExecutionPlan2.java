package persistence.edb;

import persistence.edb.operator.Operator;

public class ExecutionPlan2 extends EdbAPI {
	
	public ExecutionPlan2() {
		
	}
	
	public ExecutionPlan2(String tableName, String key, String userDirectoryPath) {
		super(tableName, key, userDirectoryPath);
	}

	@Override
	public Operator executeMixedQuery(String query) {
		// TODO Auto-generated method stub
		return null;
	}

}
