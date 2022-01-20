package test.manual;

import persistence.edb.operator.Result;
import persistence.edb.operator.TextualOperator;
import persistence.lucene.LuceneIndexer;

public class TestTextualQuery {
	public static void main(String args[]) {
		
		
		try {
			new TestLucene();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TextualOperator toper = new TextualOperator("name");
		
		toper.executeQuery("Wonderful");
		
		toper.init();
		
		Result result;
		
		while (toper.hasNext()) {
			result = toper.next();
			
			System.out.println("Result: "+result.getObject("name"));
		}
	}
}
