package persistence.edb.operator;

public class MixedOperatorPA1 implements Operator {

	private SQLOperator sqlOp;
	private TextualOperator textOp;
	
	private String sqlQuery = "";
	private String textualQuery = "";
	
	/*
	 * \brief : Separate the SQL and Lucene part of the query
	 * 			in 2 String variables.
	 */
	private void parsingQuery(String query) {
		if(query.contains("with")) {
			int indTextualQuery = query.indexOf("with");
			sqlQuery = query.substring(0, indTextualQuery-1); // Sub -1 to remove ' ' between last word and 'with'.
			textualQuery = query.substring(indTextualQuery+5); // Add +5 to skip 'with '
			
			System.out.println("SQLQuery : '" + sqlQuery + "', TextualQuery : '" + textualQuery + "'");
		}
		else {
			sqlQuery = query;
		}
	}
	
	@Override
	public void executeQuery(String query) {
		if(!query.isBlank()) {
			
			/* Divide SQL & Lucene part of Query */
			parsingQuery(query);
			
			/* Execute SQL Query */
			if(!sqlQuery.isBlank()) {
				sqlOp = new SQLOperator();
				//sqlOp.executeQuery(sqlQuery);
			}
			
			/* Execute Lucene Query */
			if(!textualQuery.isBlank()) {
				textOp = new TextualOperator();
				//textOp.executeQuery(textualQuery);
			}
		}
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Result next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

}
