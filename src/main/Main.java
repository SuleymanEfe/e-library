package main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayParser parser = new ArrayParser();
		
		Scanner myObj = new Scanner(System.in);
		
		while(true) {
			System.out.print("$:");
			String cmd = myObj.nextLine();
			
			parser.parse(cmd);
		}
	}
}
