package persistence.lucene;

import java.io.*;
import java.nio.file.*;

import org.apache.lucene.analysis.*;
import org.apache.lucene.analysis.standard.*;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.store.*;



public class LuceneIndexer {
	public static void main(String[] args) throws Exception{
		
		Analyzer analyzer = new StandardAnalyzer();

	    Path indexpath = FileSystems.getDefault().getPath("/tmp/index");
	    Directory index = FSDirectory.open(indexpath);
	    
	    IndexWriterConfig config = new IndexWriterConfig(analyzer);
	    IndexWriter w = new IndexWriter(index, config);
	    
	    File f = new File("/tmp/file.txt");
   		Document doc = new Document();
   		doc.add(new Field("name", f.getName(), TextField.TYPE_STORED));
   		doc.add(new Field("content", new FileReader(f), TextField.TYPE_NOT_STORED));
   		w.addDocument(doc);
   		
   		w.close();
   		
	    
	  }
}
