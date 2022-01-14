package test.manual;

import java.io.*;
import java.nio.file.*;

import org.apache.lucene.analysis.*;
import org.apache.lucene.analysis.standard.*;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.*;

public class TestLucene {
	public static void main(String[] args) throws Exception{
		int MAX_RESULTS = 100; //nombre max de r�ponses retourn�es
		
	    // 1. Specifier l'analyseur pour le texte.
	    //    Le m�me analyseur est utilis� pour l'indexation et la recherche
	    Analyzer analyseur = new StandardAnalyzer();

	    // 2. Creation de l'index
//	    Directory index = new RAMDirectory();  //cr�ation index en m�moire
	    Path indexpath = FileSystems.getDefault().getPath("/tmp/index"); //localisation index
	    Directory index = FSDirectory.open(indexpath);  //cr�ation index sur disque
	    
	    IndexWriterConfig config = new IndexWriterConfig(analyseur);
	    IndexWriter w = new IndexWriter(index, config);

	    // 3. Indexation des documents
	    //    Ici on indexe seulement un fichier
	    File f = new File("/tmp/fichier.txt");
   		Document doc = new Document();
   		doc.add(new Field("nom", f.getName(), TextField.TYPE_STORED));
   		doc.add(new Field("contenu", new FileReader(f), TextField.TYPE_NOT_STORED));
   		w.addDocument(doc);
   		//indexer les autres documents de la m�me fa�on
   		
   		w.close(); //on ferme le index writer apr�s l'indexation de tous les documents

    	// 4. Interroger l'index
	    DirectoryReader ireader = DirectoryReader.open(index);
	    IndexSearcher searcher = new IndexSearcher(ireader); //l'objet qui fait la recherche dans l'index
	    String reqstr = "mot1 mot2";
	    	
	    //Parsing de la requete en un objet Query
	    //  "contenu" est le champ interrog� par defaut si aucun champ n'est precis�
	    QueryParser qp = new QueryParser("contenu", analyseur); 
	    Query req = qp.parse(reqstr);

	    TopDocs resultats = searcher.search(req, MAX_RESULTS); //recherche
	    
	    // 6. Affichage resultats
	    System.out.println(resultats.totalHits + " documents correspondent");
	    for(int i=0; i<resultats.scoreDocs.length; i++) {
	    	int docId = resultats.scoreDocs[i].doc;
	    	Document d = searcher.doc(docId);
	    	System.out.println(d.get("nom") + ": score " + resultats.scoreDocs[i].score);
	    }
	    
	    // fermeture seulement quand il n'y a plus besoin d'acceder aux resultats
	    ireader.close();
	  }
	  
}