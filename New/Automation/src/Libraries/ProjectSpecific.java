package Libraries;

import java.util.List;

import BeallsFlorida.Main;

import com.thoughtworks.selenium.Selenium;

public class ProjectSpecific {
	
	public static String foldername;
	public static Character Rel_Att_DocNo;
	public static String RelatedAttachedFolderName;
	public static String DuplicatesFolderName;
	public static String EquivioEmailThreadFolderName;
	public static List subCollection;
	public static Selenium sel;
	public static int rowCount;
	public static String price;
	Genericscripts gs = new Genericscripts(getClass().getSimpleName());

	public ProjectSpecific ()throws Exception{
	sel=Main.sellaunch;
	}
	
	
}


