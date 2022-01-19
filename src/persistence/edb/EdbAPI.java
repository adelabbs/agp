package persistence.edb;

import com.mysql.jdbc.Connection;

import persistence.edb.operator.Operator;
import persistence.edb.operator.SQLOperator;
import persistence.edb.operator.TextualOperator;
import persistence.jdbc.JdbcConnection;
import persistence.lucene.LuceneIndexer;

public abstract class EdbAPI {
	
	public static final String INDEX_PATH = System.getProperty("user.dir")+"/tmp/index";
	
	private String tableName; 
	private String key;
	private String userDirectoryPath;
	
	public static final int DEFAULT_CONNECTION = 0;
	public static final int SPECIFIED_CONNECTION = 1;
	
	public EdbAPI() {
		
	}
	
	public EdbAPI(String tableName, String key, String userDirectoryPath) {
		initDataParameters(tableName, key, userDirectoryPath);
	}
	
	public void setDatabaseConnection(int connectionMode, String host, String base, String user, String password, String url) {
		JdbcConnection.setSpecifiedConnection(connectionMode, host, base, user, password, url);
	}
	
	public void initDataParameters(String tableName, String key, String userDirectoryPath) {
		this.tableName = tableName;
		this.key = key;
		this.userDirectoryPath = userDirectoryPath;
	}
	
	public void createFileDescription() {
		
	}
	
	public void createTextualIndex() {
		try {
			LuceneIndexer ind = LuceneIndexer.getInstance(INDEX_PATH);
			ind.indexing(userDirectoryPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public SQLOperator executeSQLQuery(String query) {
		SQLOperator op = new SQLOperator();
		op.executeQuery(query);	
		return op;
	}
	
	public TextualOperator executeTextualQuery(String keywordSentence) {
		TextualOperator op = new TextualOperator();
		op.executeQuery(keywordSentence);	
		return op;
	}
	
	public abstract Operator executeMixedQuery(String query);

}
