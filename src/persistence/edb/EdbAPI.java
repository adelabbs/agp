package persistence.edb;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import persistence.edb.operator.Operator;
import persistence.edb.operator.SQLOperator;
import persistence.edb.operator.TextualOperator;
import persistence.lucene.LuceneIndexer;

public abstract class EdbAPI {
	
	public static final String INDEX_PATH = System.getProperty("user.dir")+"/tmp/index";
	
	private String tableName; 
	private String key;
	private String userDirectoryPath;
	
	public EdbAPI() {
		
	}
	
	public EdbAPI(String tableName, String key, String userDirectoryPath) {
		initDataParameters(tableName, key, userDirectoryPath);
	}
	
	public void initDataParameters(String tableName, String key, String userDirectoryPath) {
		this.tableName = tableName;
		this.key = key;
		this.userDirectoryPath = userDirectoryPath;
	}
	
	public void createFileDescription(String keyName, String description) {
		String path = userDirectoryPath + "/" + keyName + ".txt";
		System.out.println(path);
		try {
			FileWriter myWriter = new FileWriter(path);
			myWriter.write(description);
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("Error occuped when creating description file of path : " + path);
			e.printStackTrace();
		}
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
