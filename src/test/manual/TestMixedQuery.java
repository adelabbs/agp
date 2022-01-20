package test.manual;

import java.util.ArrayList;
import java.util.List;

import persistence.EDBLocationPersistence;
import persistence.edb.ExecutionPlan1;

public class TestMixedQuery {
	public static void main(String args[]) {
		ExecutionPlan1 edb = new ExecutionPlan1("sites", "name", System.getProperty("user.dir")+"/tmp/sites");
		edb.createTextualIndex();
		
		EDBLocationPersistence li = new EDBLocationPersistence(edb);
		List<String> keywords = new ArrayList<String>();
		keywords.add("plongée");
		keywords.add("musée");
		keywords.add("montagne");
		li.getSiteByKeywords(keywords);
	}
}
