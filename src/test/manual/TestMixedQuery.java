package test.manual;

import persistence.edb.operator.MixedOperatorPA1;

public class TestMixedQuery {
	public static void main(String args[]) {
		MixedOperatorPA1 mixedOp = new MixedOperatorPA1();
		mixedOp.executeQuery("SELECT * FROM HOTELS with hollyday plage beach");
	}
}
