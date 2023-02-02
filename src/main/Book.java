package main;

public class Book {
	private String title;
	private String subject;
	private int publication;
	private int pages;
	private double rating;
	
	
	public Book(String title, String subject, int publication, int pages, double rating) {
		this.title = title;
		this.subject = subject;
		this.publication = publication;
		this.pages = pages;
		this.rating = rating;
	}

	public String getTitle() {
		return this.title;
	}
	
	
	public String getSubject() {
		return this.subject;
	}
	
	
	public int getPublication() {
		return this.publication;
	}
	

	public int getPages() {
		return this.pages;
	}
	
	
	public double getRating() {
		return this.rating;
	}
	
	
	public void setTitle(String title) {
		this.title = title;
	}

	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	public void setPublication(int publication) {
		this.publication = publication;
	}
	
	
	public void setPages(int pages) {
		this.pages = pages;
	}
	
	
	public void setRating(double rating) {
		this.rating = rating;
	}

	
	public String toString() {
		return this.title + " | Subject: " + this.subject + " | Page: " + this.pages + " | Publish: " + this.publication + " | " + this.rating;
	}
	
}
