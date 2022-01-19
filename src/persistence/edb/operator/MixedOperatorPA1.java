package persistence.edb.operator;

import java.util.ArrayList;
import java.util.Iterator;

public class MixedOperatorPA1 implements Operator {

	private SQLOperator sqlOp;
	private TextualOperator textOp;

	private String sqlQuery = "";
	private String textualQuery = "";

	private ArrayList<Result> textualResults;

	private ArrayList<Result> mixedResults;

	private int cursor = 0;

	/*
	 * \brief : Separate the SQL and Lucene part of the query in 2 String variables.
	 */
	private void parsingQuery(String query) {
		if (query.contains("with")) {
			int indTextualQuery = query.indexOf("with");
			sqlQuery = query.substring(0, indTextualQuery - 1); // Sub -1 to remove ' ' between last word and 'with'.
			textualQuery = query.substring(indTextualQuery + 5); // Add +5 to skip 'with '

			System.out.println("SQLQuery : '" + sqlQuery + "', TextualQuery : '" + textualQuery + "'");
		} else {
			sqlQuery = query;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void executeQuery(String query) {
		if (!query.trim().isEmpty()) {

			textualResults = new ArrayList<Result>();
			mixedResults = new ArrayList<Result>();


			/* Divide SQL & Lucene part of Query */
			parsingQuery(query);

			/* Execute Lucene Query */
			if (!textualQuery.trim().isEmpty()) {
				textOp = new TextualOperator();
				textOp.executeQuery(textualQuery);

				Result textResult;

				while (textOp.hasNext()) {
					textResult = textOp.next();
					textualResults.add(textResult);
				}
				mixedResults = (ArrayList<Result>) textualResults.clone();
			}

			/* Execute SQL Query and merge with Textual results */
			if (!sqlQuery.trim().isEmpty()) {
				sqlOp = new SQLOperator();
				System.out.println(sqlQuery);
				sqlOp.executeQuery(sqlQuery);
				
				sqlOp.init();

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
					key = (String) sqlResult.getObject(TextualOperator.KEY);

					while (!found && iterator.hasNext()) {
						tmpResult = iterator.next();
						name = (String) tmpResult.getObject(TextualOperator.KEY);

						if (name.equals(key)) {
							found = true;
							score = (float) tmpResult.getObject(TextualOperator.SCORE);
							sqlResult.addField(TextualOperator.SCORE, score);
							
							System.err.println("TMP RESULT : " + textualResults.indexOf(tmpResult));
							mixedResults.add(textualResults.indexOf(tmpResult), sqlResult);
						}
					}
					
					iterator = textualResults.iterator();
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
		System.out.println();
		Result result = mixedResults.get(cursor);
		cursor++;
		return result;
	}

	@Override
	public boolean hasNext() {
		//System.out.println(mixedResults.size());
		return cursor < mixedResults.size() - 1;
	}

}
