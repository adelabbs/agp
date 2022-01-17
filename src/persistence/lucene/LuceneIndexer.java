package persistence.lucene;

import java.io.*;
import java.nio.file.*;

import org.apache.lucene.analysis.*;
import org.apache.lucene.analysis.standard.*;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.store.*;



public class LuceneIndexer {
	
	private static LuceneIndexer indexer = null;
	
	private Analyzer analyzer; 
	private Path indexpath;
	private Directory index;
	private IndexWriterConfig config;
	private IndexWriter writer;
	
	
	private LuceneIndexer(String indexpathname) throws Exception {
		this.analyzer = new StandardAnalyzer();
		File indexdirectory = new File(indexpathname);
		emptyDirectory(indexdirectory);
		this.indexpath = FileSystems.getDefault().getPath(indexpathname);
		this.index = FSDirectory.open(indexpath);
		this.config = new IndexWriterConfig(analyzer);
		this.writer = new IndexWriter(index, config);
	 }
	
	public static LuceneIndexer getInstance(String indexpathname) {
		if (indexer == null) {
			try {
				indexer = new LuceneIndexer(indexpathname);
			} catch (Exception e) {
			}
			return indexer;
		}
		return indexer;
	}
	
	public Analyzer getAnalyzer() {
		return analyzer;
	}

	public Directory getIndex() {
		return index;
	}
	
	private void emptyDirectory(File folder){
		for(File file : folder.listFiles()){
			if(file.isDirectory()){
				emptyDirectory(file);
		    }
		    file.delete();
		}
	}
	
	public int indexing(String filespathname) throws Exception {
		
	    FileFilter filter = new TextFilesFilter();
	    String directory = filespathname;
	    int numDocs = fileIndexer(directory, filter);
	    close();
		
		return numDocs;
	}
	
	private void close() throws IOException {
		writer.close();
	}
	
	private int fileIndexer(String directory, FileFilter filter) throws Exception {
		File[] files = new File(directory).listFiles();
	    
	    for (File f: files) {
	    	if (!f.isDirectory() &&
	    		!f.isHidden() &&
	    		f.exists() &&
	    		f.canRead()) {
	    		indexFile(f, writer);
	    	}
	    }
		
		return writer.numRamDocs();
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
