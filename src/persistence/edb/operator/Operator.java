package persistence.edb.operator;

public interface Operator {
	
	public void init();
	
	public boolean next();
	
	public Result getRow();
	
	public void executeQuery(String query);
}
