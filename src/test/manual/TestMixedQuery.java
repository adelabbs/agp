package test.manual;

import java.util.ArrayList;
import java.util.List;

import persistence.LocationImplementation;
import persistence.edb.ExecutionPlan1;

public class TestMixedQuery {
	public static void main(String args[]) {
		ExecutionPlan1 edb = new ExecutionPlan1(null, null, System.getProperty("user.dir")+"/tmp/sites");
		edb.createTextualIndex();
		
		LocationImplementation li = new LocationImplementation(edb);
		List<String> keywords = new ArrayList<String>();
		keywords.add("plongée");
		keywords.add("musée");
		keywords.add("montagne");
		li.getSiteByKeywords(keywords);
	}
}
