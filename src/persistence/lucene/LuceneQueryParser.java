package persistence.lucene;

import java.nio.file.*;

import org.apache.lucene.analysis.*;
import org.apache.lucene.analysis.standard.*;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.*;

public class LuceneQueryParser {
	public static void main(String[] args) throws Exception{
		int MAX_RESULTS = 100;
		
		Analyzer analyzer = new StandardAnalyzer();
		
		Path indexpath = FileSystems.getDefault().getPath("/tmp/index");
		Directory index = FSDirectory.open(indexpath);
		
		DirectoryReader ireader = DirectoryReader.open(index);
	    IndexSearcher searcher = new IndexSearcher(ireader);
	    String reqstr = "word1 word2";
	    
	    QueryParser qp = new QueryParser("content", analyzer); 
	    Query req = qp.parse(reqstr);

	    TopDocs resultats = searcher.search(req, MAX_RESULTS);
	    
	    System.out.println(resultats.totalHits + " matching documents");
	    for(int i=0; i<resultats.scoreDocs.length; i++) {
	    	int docId = resultats.scoreDocs[i].doc;
	    	Document d = searcher.doc(docId);
	    	System.out.println(d.get("name") + ": score " + resultats.scoreDocs[i].score);
	    }
	    
	    ireader.close();
    }
}
