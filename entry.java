package inventory;

import java.util.Formatter;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
public class entry{
	public static item[] entryList=new item[200];
	public static int n=0;

	public static void main(String[] args) {
		String selector, name;
		Scanner stdin=new Scanner(System.in);
		String file="/home/wmc/Documents/code/java/project6/database.txt";
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

	public static void readIn(String filename){
		try 
		{
			FileReader fr=new FileReader(filename);
			BufferedReader br= new BufferedReader(fr);
			String[] lines=new String[200];
			for (int i;i<200;++i)
			{
				lines[i]=br.readLine();
				System.out.println(lines[i]);
			}
			br.close();
			return;	
		} catch (Exception e) {
			e.printStackTrace();
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
		index=find(name);
		if (index != -1) //found entry
		{
			entryList[index].qnty=qty;
		}
		else
		{
			entryList[++n].name=name;
			entryList[n].qnty+=qty;
			entryList[n].notes=notes;
		}
		return;
	}

	public static void WriteInventory(String FileName) throws Exception{
		Formatter out=new Formatter(FileName);
		for (int x=0; x < n; ++x)
		{
			out.format("%s %d %s%n", entryList[x].name, entryList[x].qnty, entryList[x].notes);
		}
	}

	public static int find(String to_Search) //just a placeholder. Delete when the real one exists
	{
		return 2;
	}
}
