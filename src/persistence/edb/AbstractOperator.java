package persistence.edb;

public interface AbstractOperator {
	void init();
	AbstractOperator next();
}
