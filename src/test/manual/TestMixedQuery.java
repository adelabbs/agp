package test.manual;

import java.util.ArrayList;
import java.util.List;

import persistence.EDBLocationPersistence;
import persistence.edb.ExecutionPlan1;

public class TestMixedQuery {
	public static void main(String args[]) {
		EDBLocationPersistence li = new EDBLocationPersistence("sites", "name", System.getProperty("user.dir")+"/tmp/sites");
		List<String> keywords = new ArrayList<String>();
		keywords.add("plongée");
		keywords.add("musée");
		keywords.add("montagne");
		li.getSiteByKeywords(keywords);
	}
}
