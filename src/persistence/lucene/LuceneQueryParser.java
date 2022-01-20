package persistence.lucene;


import org.apache.lucene.analysis.*;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.*;

public class LuceneQueryParser {
	
	LuceneIndexer indexer;
	IndexSearcher searcher;
	
	public LuceneQueryParser(LuceneIndexer indexer) throws Exception{
		this.indexer = indexer;
	}
	
	
	public IndexSearcher getSearcher() {
		return searcher;
	}
	
	public TopDocs search(String reqstr) throws Exception {
		int MAX_RESULTS = 100;
		
		Analyzer analyzer = indexer.getAnalyzer();
	
		Directory index = indexer.getIndex();
		
		DirectoryReader ireader = DirectoryReader.open(index);
	    searcher = new IndexSearcher(ireader);
	    
	    QueryParser qp = new QueryParser("content", analyzer); 
	    Query req = qp.parse(reqstr);

	    TopDocs resultats = searcher.search(req, MAX_RESULTS);
	    /*
	    System.out.println(resultats.totalHits + " matching documents");
	    for(int i=0; i<resultats.scoreDocs.length; i++) {
	    	int docId = resultats.scoreDocs[i].doc;
	    	Document d = searcher.doc(docId);
	    	System.out.println(d.get("name") + ": score " + resultats.scoreDocs[i].score);
	    }
	    
	    ireader.close();*/
	    return resultats;
    }
}
