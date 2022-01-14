package persistence.edb;

public interface EDB {
	AbstractOperator execQuerySQL(String query);
	AbstractOperator execMixedQuery(String query);
}
