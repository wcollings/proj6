import java.io.FileReader;
import java.io.BufferedReader;
public class entry{
	public string name, number, notes;
	public static void readInventory(string filename) throws exception
	{
		FileReader fr=new fileReader(filename);
		BufferedReader text=new BufferedReader(fr);

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