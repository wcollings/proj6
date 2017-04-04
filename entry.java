package inventory;

import java.util.Formatter;
import java.util.Scanner;
import java.io.*;
public class entry{
	public static item[] entryList=new item[200];
	public static int n=0;

	public static void main(String[] args) {
		String selector, name;
		Scanner stdin=new Scanner(System.in);
		String file="database.txt";
		readIn(file);
		System.out.print("Command: ");
		selector=stdin.next();
		name=stdin.next();
		selector=selector.toLowerCase();
		switch(selector)
		{
			case "e": enter(name);
		}

	}

	public static void readIn(String filename)
	{
		try {
			Scanner in=new Scanner(new File(filename));
			while (in.hasNext())
			{
				entryList[n].name=in.next();
				entryList[n].qnty=in.nextInt();
				entryList[n].notes=in.next();
				n++;
			}
		
		FileReader fr=new fileReader(filename);
		BufferedReader text=new BufferedReader(fr);

			} catch(Exception e) {};
		System.out.print("Read database successfully\n");
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
		index=2; //find is being worked on
		if (index != -1) //found entry
		{
			entryList[index].qnty+=qty;
		}
		else
		{
			entryList[++n].name=name;
			entryList[n].qnty=qty;
			entryList[n].notes=notes;
		}
	}

	public static void WriteInventory(String FileName) throws Exception{
		Formatter out=new Formatter(FileName);
		for (int x=0; x < n; ++x)
		{
			out.format("%s %d %s%n", entryList[x].name, entryList[x].qnty, entryList[x].notes);
		}
}
}
