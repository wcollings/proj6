package inventory;
import java.io.FileReader;
import java.io.BufferedReader;
import item.java;
public class entry{
	public static item[] list=new item[200];


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