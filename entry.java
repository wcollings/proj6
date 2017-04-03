package inventory;

import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import item.java;
public class entry{
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

	public static void enter(String name)
	{
		Scanner stdin=new Scanner(System.in);
		int qty, index;
		String notes;
		System.out.printf("Enter quantity: ");
		qty=stdin.nextInt();
		System.out.printf("Enter notes: ");
		notes=stdin.next();
		index=find(name); //find is being worked on
		if (index != -1) //found entry
		{
			list[index].number+=qty;
		}
		else
		{
			list[++n].name=name;
			list[n].number=qty;
			list[n].notes=notes;

		}
	}

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
