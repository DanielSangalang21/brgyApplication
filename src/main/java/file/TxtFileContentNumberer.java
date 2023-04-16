package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TxtFileContentNumberer {

	public static void main(String[] args) throws FileNotFoundException {
		String fileL = "C:\\Users\\Daniel\\Desktop\\LOA - project\\Patch\\needed TIP&AMM\\[LOA] VA Patch\\2021053 - VA Findings\\2021053 - VA Findings Patch\\Objects\\OTP_SYSTEM\\fileList.txt";
		File f = new File(fileL);
		String compareString = "OTP_SYSTEM.war";
		
		 Scanner myReader = new Scanner(f);
		 int counter = 1;
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        if(data.substring(0, 14).equals(compareString)) {
	        	data = counter+". "+data;
	        }
	        System.out.println(data);
	        counter++;
	      }

	}

}
