package persistence.edb;

public interface EDB_API {
	AbstractOperator execQuerySQL(String query);
	AbstractOperator execMixedQuery(String query);
}
