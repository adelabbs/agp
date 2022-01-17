package persistence.edb.operator;

public interface Operator {
	
	public void init();
	
	public Result next();
	
	public boolean hasNext();
	
	public void executeQuery(String query);
}
