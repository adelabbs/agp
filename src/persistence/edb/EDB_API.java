package persistence.edb;

import persistence.edb.operator.Operator;

public abstract class EDB_API {
	
	public EDB_API() {
		
	}
	
	void initDataParameters() {
		
	}
	void createFileDescription() {
		
	}
	
	void createTextualIndex() {
		
	}
	
	Operator execSQLQuery() {
		return null;	
	}
	
	abstract Operator execMixedQuery();

}
