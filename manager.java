package inventory;

import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import item.java;
public class manager{
	public static item[] list=new item[200];
	public static int n=0;

	public static void main(String[] args) {
		String selector;
		Scanner stdin=new Scanner(System.in);
		System.out.print("Command: ");
		selector=stdin.next;
		selector=tolowercase(selector);
		switch(selector)
		{
			case 'e':
		}

	}

	public static void enter();

	public static void WriteInventory(String FileName) throws Exception{
		PrintStream P  = new PrintStream(FileName);
							
		for (int i=0; i < num_entries; i++) {
			P.println(entryList[i].name      + "\t" +
					entryList[i].quantity  + "\t" +
					entryList[i].notes);
		}
		P.close();
		System.out.println("Inventory stored.");		
}
	
}