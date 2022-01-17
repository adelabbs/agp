package test.manual;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

import persistence.lucene.*;

public class TestLucene {
	public static void main(String[] args) throws Exception{
		String[] testNames = {"site1", "site2", "amazingsite"};
		
		PrintWriter writer;
		
		String localDir = System.getProperty("user.dir");
		
		
		for (String name: testNames) {
			
			writer = new PrintWriter(localDir+"/tmp/files/"+name+".txt", "UTF-8");
			writer.println("Template text about a site, which could be anything but surely wonderful.");
			writer.close();
				
		}
		
		System.out.println("yo");
		String sysdir = System.getProperty("user.dir");
		
		
		LuceneIndexer indexer = new LuceneIndexer(sysdir+"/tmp/index");
		
		int num = indexer.indexing(sysdir+"/tmp/files");
	    
	    System.out.println("Indexed "+num+" files out of "+testNames.length);
	}
}