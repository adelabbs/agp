package test.manual;

import persistence.edb.ExecutionPlan1;

public class TestCreateFileDescription {
	public static void main(String[] args) {
		ExecutionPlan1 ebd = new ExecutionPlan1(null, null, System.getProperty("user.dir")+"/tmp/sites");
		ebd.createFileDescription("testDescription", "Rick Rolled");
	}
}
