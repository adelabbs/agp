package persistence.edb;

import persistence.edb.operator.MixedOperatorPA1;
import persistence.edb.operator.Operator;

public class ExecutionPlan1 extends EDB_API {
	
	public ExecutionPlan1() {
		
	}
	
	public ExecutionPlan1(String tableName, String key, String userDirectoryPath) {
		super(tableName, key, userDirectoryPath);
	}

	public Operator executeMixedQuery(String query) {
		MixedOperatorPA1 op = new MixedOperatorPA1();
		op.executeQuery(query);	
		return op;
	}

}
