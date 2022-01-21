package persistence.edb.operator;

import java.util.ArrayList;
import java.util.Iterator;

public class MixedOperator implements Operator {
	
	private String textualKey;

	private SQLOperator sqlOp;
	private TextualOperator textOp;

	private String sqlQuery = "";
	private String textualQuery = "";

	private ArrayList<Result> textualResults;

	private ArrayList<Result> mixedResults;
	private boolean existMixedResults = false; // Check if mixedResults has been filled with proper data.
	
	private int cursor = 0;
		
	public MixedOperator(String textualKey) {
		this.textualKey = textualKey;
	}
	
	/*
	 * \brief : Separate the SQL and Lucene part of the query in 2 String variables.
	 */
	private void parsingQuery(String query) {
		if (query.contains("with")) {
			int indTextualQuery = query.indexOf("with");
			sqlQuery = query.substring(0, indTextualQuery - 1); // Sub -1 to remove ' ' between last word and 'with'.
			textualQuery = query.substring(indTextualQuery + 5); // Add +5 to skip 'with '
		} else {
			sqlQuery = query;
		}
	}

	@Override
	public void executeQuery(String query) {
		if (!query.trim().isEmpty()) {

			textualResults = new ArrayList<Result>();
			mixedResults = new ArrayList<Result>();

			/* Divide SQL & Lucene part of Query */
			parsingQuery(query);

			/* Execute Lucene Query */
			if (!textualQuery.trim().isEmpty()) {
				textOp = new TextualOperator(textualKey);
				textOp.executeQuery(textualQuery);

				Result textResult;

				while (textOp.hasNext()) {
					textResult = textOp.next();
					textualResults.add(textResult);
				}
				
				for(int i = 0; i< textualResults.size(); i++) {
					mixedResults.add(i, null);
				}
			}

			/* Execute SQL Query and merge with Textual results */
			if (!sqlQuery.trim().isEmpty()) {
				sqlOp = new SQLOperator();
				sqlOp.executeQuery(sqlQuery);
				
				if(sqlOp.existResultSet()) {
					String name;
					String key;

					float score;

					Result sqlResult;
					Result tmpResult;

					boolean found;

					Iterator<Result> iterator = textualResults.iterator();
					while (sqlOp.hasNext()) {
						found = false;

						sqlResult = sqlOp.next();
						key = (String) sqlResult.getObject(textualKey);

						while (!found && iterator.hasNext()) {
							tmpResult = iterator.next();
							name = (String) tmpResult.getObject(textualKey);

							if (name.equals(key)) {
								found = true;
								score = (float) tmpResult.getObject(TextualOperator.SCORE);
								sqlResult.addField(TextualOperator.SCORE, score);
								mixedResults.set(textualResults.indexOf(tmpResult), sqlResult);
								setExistMixedResults(true);
							}
						}
						iterator = textualResults.iterator();
					}
					
					/* Temporary fix to remove Result that are null */
					ArrayList<Result> toRemove = new ArrayList<Result>();
					for(Result res : mixedResults) {
						if(res == null) {
							toRemove.add(res);
						}
					}
					
					for(Result res : toRemove) {
						mixedResults.remove(res);
					}
				}
			}
		}
	}

	@Override
	public void init() {
		cursor = 0;

	}

	@Override
	public Result next() {
		Result result = mixedResults.get(cursor);
		cursor++;
		return result;
	}

	@Override
	public boolean hasNext() {
		return cursor < mixedResults.size() - 1;
	}

	public boolean isExistMixedResults() {
		return existMixedResults;
	}

	public void setExistMixedResults(boolean existMixedResults) {
		this.existMixedResults = existMixedResults;
	}
}
