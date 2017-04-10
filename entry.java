package inventory;

import java.util.Formatter;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.BufferedReader;
public class entry{
	public static item[] entryList=new item[200];
	public static int n=0;
 
	public static void main(String[] args) {
		String selector, name;
		instantiate();
		Scanner stdin=new Scanner(System.in);
		String file="/home/wmc/Documents/code/java/project6/database.txt";
		readIn(file);
		System.out.print("Command: ");
		selector=stdin.next();
		selector=selector.toLowerCase();
		dance: for (;;) {
			switch(selector)
			{
				case "e":{
					name=stdin.next();
					enter(name);
					}
					break;
				case "f":
				{
					name=stdin.next();
					print(find(name));
				}
					break;
				case "l": list();
					break;
				case "q": break dance; //YEAH!
			}
		System.out.print("Command: ");
		selector=stdin.next();
		selector=selector.toLowerCase();
	}
		try{
		WriteInventory(file);
	} catch (Exception e) {
		System.err.println(e);
	}
		System.out.println("Thanks for using this system!");
	}

	public static void readIn(String filename){
		try 
		{
			int i=0;
			FileReader fr=new FileReader(filename);
			BufferedReader br= new BufferedReader(fr);
			String line;
			line=br.readLine();
			do
			{
				line+=" "+br.readLine()+ " ";
				line+=br.readLine();
				//System.out.printf("%s: %d%n\t%s%n",entryList[i].name, entryList[i].qnty, entryList[i].notes);
				process(line, i);
				++n;
				line=br.readLine()+ " ";
				line=br.readLine();
			}while ( ++i< 200 && line !=null);
			br.close();
			return;	
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
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
		if (index == -9) //didn't find entry
		{
			System.out.print(". Creating...");
			entryList[n].name=name;
			entryList[n].qnty+=qty;
			entryList[n].notes=notes;
			n++;
			System.out.println("done");
		}
		else 
			entryList[index].qnty+=qty;
		return;
	}

	public static void WriteInventory(String FileName) throws Exception{
   PrintStream P  = new PrintStream(FileName);
		 			
   for (int i=0; i < n; i++) {
	P.println(entryList[i].name      + "\t" +
	          entryList[i].qnty  + "\t" +
		    entryList[i].notes);
   }
   P.close();
   System.out.println("Inventory stored.");	
}

	public static int find(String to_Search)
	{
		for (int i = 0; i < n;++i){
		if (to_Search.equals(entryList[i].name)){
		return i;}
		}
		System.out.print("No entry found for "+to_Search);
		return -9;
	}
	public static void list()
	{ 
		for (int i = 0; i < n; i++)
			print(i);
	}

public static void print(int flamingo)
{
	System.out.printf("%s: %d%n\t->%s%n",entryList[flamingo].name, entryList[flamingo].qnty,entryList[flamingo].notes);
}

public static void process (String line, int place)
{
	System.out.println(line);
	try {
	int where, where2;
	where2=line.indexOf(" ");
	entryList[place].name=line.substring(0, where2);
	where=where2;
	where2=line.indexOf(" ", where+1);
	entryList[place].qnty=Integer.parseInt(line.substring(where+1, where2));
	where=where2;
	entryList[place].notes=line.substring(where+1);
	} catch (NullPointerException e) {
		System.out.println("?????\nGood job\n");
	}
}

public static void instantiate()
{
  for (int i=0;i <200; ++i)
  {
    entryList[i]=new item();
  }
}
}
