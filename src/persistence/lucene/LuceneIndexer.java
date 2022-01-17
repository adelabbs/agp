package persistence.lucene;

import java.io.*;
import java.nio.file.*;

import org.apache.lucene.analysis.*;
import org.apache.lucene.analysis.standard.*;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.store.*;



public class LuceneIndexer {
	
	public LuceneIndexer() throws Exception{
		
		Analyzer analyzer = new StandardAnalyzer();

	    Path indexpath = FileSystems.getDefault().getPath(localDir+"/tmp/index");
	    Directory index = FSDirectory.open(indexpath);
	    
	    IndexWriterConfig config = new IndexWriterConfig(analyzer);
	    w = new IndexWriter(index, config);
	    
	    FileFilter filter = new TextFilesFilter();
	    
	    String directory = localDir+"/tmp/files";
	    
	    int numDocs = fileIndexer(directory, filter);
	    
	    close();
	    
	    System.out.println("Indexed "+numDocs+" files");
   		
	  }
	
	private IndexWriter w;
	
	private String localDir = System.getProperty("user.dir");
	
	public void close() throws IOException {
		w.close();
	}
	
	public int fileIndexer(String directory, FileFilter filter) throws Exception {
		
		
		
		File[] files = new File(directory).listFiles();
	    
	    for (File f: files) {
	    	if (!f.isDirectory() &&
	    		!f.isHidden() &&
	    		f.exists() &&
	    		f.canRead()) {
	    		indexFile(f, w);
	    	}
	    }
		
		return w.numRamDocs();
	}
	
	private static class TextFilesFilter implements FileFilter {
		public boolean accept(File path) {
			return path.getName().toLowerCase().endsWith(".txt");
		}
	}
	
	private void indexFile(File f, IndexWriter w) throws Exception {
		Document doc = new Document();
   		doc.add(new Field("name", f.getName(), TextField.TYPE_STORED));
   		doc.add(new Field("content", new FileReader(f), TextField.TYPE_NOT_STORED));
   		w.addDocument(doc);
	}
	
}