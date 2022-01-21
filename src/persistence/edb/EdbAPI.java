package persistence.edb;

import java.io.FileWriter;
import java.io.IOException;

import persistence.edb.operator.Operator;
import persistence.edb.operator.SQLOperator;
import persistence.edb.operator.TextualOperator;
import persistence.jdbc.JdbcConnection;
import persistence.lucene.LuceneIndexer;

/**
 * 
 * The extended database API uses JDBC for SQL queries and Lucene for textual
 * queries.
 * 
 */
public abstract class EdbAPI {

	public static final String INDEX_PATH = System.getProperty("java.io.tmpdir") + "test/lucene/index";

	private String tableName;
	private String key;
	private String userDirectoryPath;

	public static final int DEFAULT_CONNECTION = 0;
	public static final int SPECIFIED_CONNECTION = 1;

	public EdbAPI() {
		createTextualIndex();
	}

	public EdbAPI(String tableName, String key, String userDirectoryPath) {
		initDataParameters(tableName, key, userDirectoryPath);
		createTextualIndex();
	}

	public void setDatabaseConnection(int connectionMode, String host, String base, String user, String password,
			String url) {
		JdbcConnection.setSpecifiedConnection(connectionMode, host, base, user, password, url);
	}

	/**
	 * Specifies the tableName, the name of the key attribute of this table and the
	 * path to the directory where textual data is stored.
	 * 
	 * @param tableName
	 * @param key
	 * @param userDirectoryPath
	 */
	public void initDataParameters(String tableName, String key, String userDirectoryPath) {
		this.setTableName(tableName);
		this.setKey(key);
		this.userDirectoryPath = userDirectoryPath;
	}

	/**
	 * Add a description to the key c, creating the associated file in the
	 * userDirectoryPath
	 * 
	 * The name of the table, the name of the key attribute and the
	 * userDirectoryPath must be provided first by calling initDataParameters();
	 * 
	 * @param keyName     the key value
	 * @param description the description text
	 */
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

	/**
	 * The mixed query implementation depends of the execution plan
	 * 
	 * @param query
	 * @return {@link Operator} and iterator on the results
	 */
	public abstract Operator executeMixedQuery(String query);

	public SQLOperator executeSQLQuery(String query) {
		SQLOperator op = new SQLOperator();
		op.executeQuery(query);
		return op;
	}

	public TextualOperator executeTextualQuery(String keywordSentence) {
		TextualOperator op = new TextualOperator(key);
		op.executeQuery(keywordSentence);
		return op;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
