

public class SearchUtilities {
  private static SearchSpec[] commonSpecs =
    { new SearchSpec("Google",
                     "http://www.google.com/search?q="),
      new SearchSpec("Bing",
                     "http://www.bing.com/search?q="),
      new SearchSpec("Yahoo",
                     "http://search.yahoo.com/bin/search?p="),
      new SearchSpec("Ask",
                     "http://www.ask.com/web?q="),               
      
      new SearchSpec("Lycos",
                     "http://search.lycos.com/default.asp?query="),
      new SearchSpec("HotBot",
                     "http://hotbot.com/default.asp?query="),
    };
  
  public static SearchSpec[] getCommonSpecs() {
    return(commonSpecs);
  }

  /** Given a search engine name and a search string, builds
   *  a URL for the results page of that search engine
   *  for that query. Returns null if the search engine name
   *  is not one of the ones it knows about.
   */
  
  public static String makeURL(String searchEngineName,
                               String searchString) {
    SearchSpec[] searchSpecs = getCommonSpecs();
    String searchURL = null;
    for(SearchSpec spec: searchSpecs) {
      if (spec.getName().equalsIgnoreCase(searchEngineName)) {
        searchURL = spec.makeURL(searchString);
        break;
      }
    }
    return(searchURL);
  }
}
