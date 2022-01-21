package persistence.edb.operator;

/**
 * 
 * A concrete Operator must be implemented as an iterator on the query results.
 * Therefore it provides init() and next() methods in order to iterate through
 * the result set.
 *
 */
public interface Operator {

	/**
	 * Resets the cursor to the initial position, i.e. to point to the first result in the set.
	 */
	public void init();

	/**
	 * 
	 * @return the next {@link Result}
	 */
	public Result next();

	/**
	 * 
	 * @return true if the contains result set contains a next result item
	 */
	public boolean hasNext();

	public void executeQuery(String query);
}
