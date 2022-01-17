package persistence.edb;

public interface EDB_API {
	void initDataParameters();
	void createFileDescription();
	void createTextualIndex();
	abstract AbstractOperator execMixedQuery();
	AbstractOperator execSQLQuery();
}
