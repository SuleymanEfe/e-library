package main;

public class ArrayParser {
	Library library = new Library();
	
	private static final String ADD = "ADD";
	private static final String LIST = "LIST";
	private static final String SORT_BY_TITLE = "SORT_BY_TITLE";
	private static final String SORT_BY_PAGE = "SORT_BY_PAGE";
	private static final String SORT_BY_PUBLICATION = "SORT_BY_PUBLICATION";
	private static final String SORT_BY_RATING = "SORT_BY_RATING";
	private static final String SEARCH = "SEARCH";
	private static final String SEARCH_CATEGORY = "SEARCH_CATEGORY";
	private static final String HELP = "HELP";
	private static final String EXIT = "EXIT";
	
	private static final String OK = "OK";
	private static final String INVALID = "Invalid input for %s. See commands for help.";
	private static final String UNRECOGNIZED = "Unrecognized command. See commands for help.";
	
	private static final String HELP_TEXT = "ADD <title> <subject> <publication> <pages> <rating>\n"
			+ "LIST\n"
			+ "SORT_BY_TITLE\n"
			+ "SORT_BY_PAGE\n"
			+ "SORT_BY_PUBLICATION\n"
			+ "SORT_BY_RATING\n"
			+ "SEARCH <search_text>\n"
			+ "SEARCH_CATEGORY <search_text>\n"
			+ "EXIT\n"
			+ "HELP";
	
	
	public ArrayParser() {
		library.initialize();
		this.parse(HELP);
	}
	
	// Take input from the user and parse it for known commands
	// @param s a String containing what the user typed (one or more words)
	// reports unrecognized commands to the Gui
	public void parse(String s)
	{
		// Tokenize
		String[] tokenz = s.split(" ");
		
		String cmd = tokenz[0].toUpperCase();
		
		if (cmd.equals(ADD)) {
			add(tokenz);
		} else if(cmd.equals(LIST)) {
			sortByTitle(tokenz);
		} else if(cmd.equals(SORT_BY_TITLE)) {
			sortByTitle(tokenz);
		} else if(cmd.equals(SORT_BY_PAGE)) {
			sortByPage(tokenz);
		} else if(cmd.equals(SORT_BY_PUBLICATION)) {
			sortByPublication(tokenz);
		} else if(cmd.equals(SORT_BY_RATING)) {
			sortByRating(tokenz);
		} else if(cmd.equals(SEARCH)) {
			search(tokenz);
		} else if(cmd.equals(SEARCH_CATEGORY)) {
			searchByCategory(tokenz);
		} else if(cmd.equals(HELP)) {
			System.out.println(HELP_TEXT);
		} else if (cmd.equals(EXIT)) {
			System.exit(0);
		} else {
			System.out.println(UNRECOGNIZED);
		}		
	}
	
	private void add(String[] tokenz)
	{
		String feedback;

		try{
			if (tokenz.length == 6) {
				library.addBook(tokenz[1], tokenz[2], Integer.parseInt(tokenz[3]), Integer.parseInt(tokenz[4]), Double.parseDouble(tokenz[5]));
				feedback = OK;
			} else {
				feedback = String.format(INVALID, "add");
			}
		} catch(Exception e){
			feedback = String.format(INVALID, "add");
		}
		
		System.out.println(feedback);
	}
	
	private void sortByTitle(String[] tokenz)
	{
		String feedback;

		try{
			if (tokenz.length == 1) {
				feedback = library.sortByTitle(true).toString();
				
			} else {
				feedback = String.format(INVALID, "sort by title");
			}
		} catch(Exception e){
			feedback = String.format(INVALID, "sort by title");
		}
		
		System.out.println(feedback);
	}
	
	private void sortByPublication(String[] tokenz)
	{
		String feedback;

		try{
			if (tokenz.length == 1) {
				feedback = library.sortByPublicationYear(true).toString();
				
			} else {
				feedback = String.format(INVALID, "sort by publication");
			}
		} catch(Exception e){
			feedback = String.format(INVALID, "sort by publication");
		}
		
		System.out.println(feedback);
	}
	
	private void sortByRating(String[] tokenz)
	{
		String feedback;

		try{
			if (tokenz.length == 1) {
				feedback = library.sortByRating(true).toString();
				
			} else {
				feedback = String.format(INVALID, "sort by rating");
			}
		} catch(Exception e){
			feedback = String.format(INVALID, "sort by rating");
		}
		
		System.out.println(feedback);
	}
	
	private void sortByPage(String[] tokenz)
	{
		String feedback;

		try{
			if (tokenz.length == 1) {
				feedback = library.sortByPageCount(true).toString();
				
			} else {
				feedback = String.format(INVALID, "sort by page");
			}
		} catch(Exception e){
			feedback = String.format(INVALID, "sort by page");
		}
		
		System.out.println(feedback);
	}
	
	private void search(String[] tokenz)
	{
		String feedback;

		try{
			if (tokenz.length == 2) {
				feedback = library.search(tokenz[1]).toString();
				
			} else {
				feedback = String.format(INVALID, "search");
			}
		} catch(Exception e){
			feedback = String.format(INVALID, "search");
		}
		
		System.out.println(feedback);
	}
	
	private void searchByCategory(String[] tokenz)
	{
		String feedback;

		try{
			if (tokenz.length == 2) {
				feedback = library.search(tokenz[1]).toString();
				
			} else {
				feedback = String.format(INVALID, "search by category");
			}
		} catch(Exception e){
			feedback = String.format(INVALID, "search by category");
		}
		
		System.out.println(feedback);
	}

	
	
}