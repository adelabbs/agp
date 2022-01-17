package persistence.edb;

import persistence.edb.operator.Operator;
import persistence.lucene.LuceneIndexer;

public abstract class EDB_API {
	
	private String tableName; 
	private String key;
	private String userDirectoryPath;
	
	public EDB_API(String tableName, String key, String userDirectoryPath) {
		initDataParameters(tableName, key, userDirectoryPath);
	}
	
	void initDataParameters(String tableName, String key, String userDirectoryPath) {
		this.tableName = tableName;
		this.key = key;
		this.userDirectoryPath = userDirectoryPath;
	}
	
	void createFileDescription() {
		
	}
	
	void createTextualIndex() {
		try {
			LuceneIndexer.getInstance(userDirectoryPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	Operator executeSQLQuery(String query) {
		return null;	
	}
	
	abstract Operator executeMixedQuery(String query);

}
