package persistence.edb;

import persistence.edb.operator.MixedOperator;
import persistence.edb.operator.Operator;
import persistence.edb.operator.SQLOperator;
import persistence.edb.operator.TextualOperator;

/**
 * 
 * The first execution plan executes a mixed query by iterating through the SQL
 * results provided by the {@link SQLOperator} and browse the results of the
 * textual query in {@link TextualOperator} to look for the key (if it exists)
 * and its score.
 *
 */
public class ExecutionPlan1 extends EdbAPI {

	public ExecutionPlan1() {

	}

	public ExecutionPlan1(String tableName, String key, String userDirectoryPath) {
		super(tableName, key, userDirectoryPath);
	}

	public Operator executeMixedQuery(String query) {
		MixedOperator op = new MixedOperator(this.getKey());
		op.executeQuery(query);
		return op;
	}

}
