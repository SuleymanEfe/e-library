package main;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import arrayList.ArrayList;

public class Library {
	private static Library instance = null;
	
	private ArrayList<Book> libraryArrayList = new ArrayList<>();
	
	public Library() {}
	
	public static Library getInstance() {
	    if (instance == null) {
	        instance = new Library();
	    }
	    return instance;
	}
	
	public void initialize() {
		Path filePath = Paths.get("library.txt");
		
	    try {
	        List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
	        
	        for(String line : lines) {
	        	String title = line.split("::")[0];
	        	String subject = line.split("::")[1];
	        	int publication = Integer.parseInt(line.split("::")[2]);
	        	int pages = Integer.parseInt(line.split("::")[3]);
	        	double rating = Double.parseDouble(line.split("::")[4]);
	        	
	        	Book book = new Book(title, subject, publication, pages, rating);
	        	this.libraryArrayList.add(book);
	        }
	        
	    } catch (IOException ex) {
	        System.out.format("I/O error: %s%n", ex);
	    }		
	}
	
	public int getLibrarySize() {
		return libraryArrayList.getSize();
	}
	
	public void addBook(String title, String subject, int publication, int pages, double rating) {
		try {
			FileWriter myWriter = new FileWriter("library.txt", true);
			myWriter.write("\n" + title + "::" + subject + "::" + publication + "::" + pages + "::" + rating);
			myWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
	        e.printStackTrace();
		}
		
		Book book = new Book(title, subject, publication, pages, rating);
		this.libraryArrayList.add(book);
	}
	
	public ArrayList<Book> sortByTitle(Boolean ascending){
		boolean swapped = true;
		
		while(swapped) {
			swapped = false;
			
			for(int i = 0; i < libraryArrayList.getSize() - 1; i++) {
				Book b1 = libraryArrayList.get(i);
				Book b2 = libraryArrayList.get(i + 1);
				
				if(ascending ? ( Character.toLowerCase(b1.getTitle().charAt(0)) > Character.toLowerCase(b2.getTitle().charAt(0)) ) : 
					(Character.toLowerCase(b1.getTitle().charAt(0)) < Character.toLowerCase(b2.getTitle().charAt(0)))){
					
					libraryArrayList.set(i, b2);
					libraryArrayList.set(i + 1, b1);
					swapped = true;
				}
			}
		}
		
		return libraryArrayList;
		
	
	}
	
	public ArrayList<Book> sortByPageCount(Boolean ascending){
		boolean swapped = true;
		
		while(swapped) {
			swapped = false;
			
			for(int i = 0; i < libraryArrayList.getSize() - 1; i++) {
				Book b1 = libraryArrayList.get(i);
				Book b2 = libraryArrayList.get(i + 1);
				
				if(ascending ? ( b1.getPages() > b2.getPages() ) : ( b1.getPages() < b2.getPages() )) {
					libraryArrayList.set(i, b2);
					libraryArrayList.set(i + 1, b1);
					swapped = true;
				}
			}
		}
		
		return libraryArrayList;
		
	
	}
	
	public ArrayList<Book> sortByPublicationYear(Boolean ascending){
		boolean swapped = true;
		
		while(swapped) {
			swapped = false;
			
			for(int i = 0; i < libraryArrayList.getSize() - 1; i++) {
				Book b1 = libraryArrayList.get(i);
				Book b2 = libraryArrayList.get(i + 1);
				
				if(ascending ? ( b1.getPublication() > b2.getPublication() ) : ( b1.getPublication() < b2.getPublication() )) {
					libraryArrayList.set(i, b2);
					libraryArrayList.set(i + 1, b1);
					swapped = true;
				}
			}
		}
		
		return libraryArrayList;
	}
	
	public ArrayList<Book> sortByRating(Boolean ascending){
		boolean swapped = true;
		
		while(swapped) {
			swapped = false;
			
			for(int i = 0; i < libraryArrayList.getSize() - 1; i++) {
				Book b1 = libraryArrayList.get(i);
				Book b2 = libraryArrayList.get(i + 1);
				
				if(ascending ? ( b1.getRating() > b2.getRating() ) : ( b1.getRating() < b2.getRating() )) {
					libraryArrayList.set(i, b2);
					libraryArrayList.set(i + 1, b1);
					swapped = true;
				}
			}
		}
		
		return libraryArrayList;
		
	
	}

	public ArrayList<Book> search(String search){
		ArrayList<Book> temp = new ArrayList<Book>();
		
		for(int i = 0; i < libraryArrayList.getSize(); i++) {
			Book b = libraryArrayList.get(i);
			
			if(b.getTitle().toLowerCase().contains(search.toLowerCase())) {
				temp.add(b);
			}
		}
		
		return temp;
	}

	public ArrayList<Book> listByCategory(String search){
		ArrayList<Book> temp = new ArrayList<Book>();
		
		for(int i = 0; i < libraryArrayList.getSize(); i++) {
			Book b = libraryArrayList.get(i);
			
			if(b.getSubject().toLowerCase().contains(search.toLowerCase())) {
				temp.add(b);
			}
		}
		
		return temp;
	}

}
