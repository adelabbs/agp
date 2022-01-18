package persistence.edb.operator;

import org.apache.lucene.document.Document;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.TopDocs;

import persistence.lucene.LuceneIndexer;
import persistence.lucene.LuceneQueryParser;

public class TextualOperator implements Operator {

	private TopDocs results;
	private LuceneIndexer indexer;
	private LuceneQueryParser parser;

	private int cursor = 0;
	private String SEPARATOR = "\\.";

	@Override
	public void executeQuery(String query) {
		indexer = LuceneIndexer.getInstance("");
		try {
			parser = new LuceneQueryParser(indexer);

			results = parser.search(query);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void init() {
		cursor = 0;

	}

	@Override
	public Result next() {
		Result result = new Result();

		try {
			if (cursor < results.scoreDocs.length) {
				int docId = results.scoreDocs[cursor].doc;

				IndexSearcher searcher = parser.getSearcher();

				Document d = searcher.doc(docId);

				String fileName = d.get("name");
				String[] fields = fileName.split(SEPARATOR);

				result.addField("name", fields[0]);
				result.addField("score", results.scoreDocs[cursor].score);
				cursor++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public boolean hasNext() {
		boolean bool = cursor < results.totalHits.value;

		return bool;
	}

}
