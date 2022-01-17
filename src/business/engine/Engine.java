package business.engine;

public class Engine {

	private SearchEntry searchEntry;

	private SearchResultsManager searchResultsManager;

	public Engine() {

	}

	public SearchEntry getSearchEntry() {
		return searchEntry;
	}

	public void setSearchEntry(SearchEntry searchEntry) {
		this.searchEntry = searchEntry;
	}

	public void setSearchResultsManager(SearchResultsManager searchResultsManager) {
		this.searchResultsManager = searchResultsManager;
	}

	public SearchResultsManager getSearchResultsManager() {
		return searchResultsManager;
	}

}