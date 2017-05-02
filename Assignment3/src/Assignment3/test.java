package Assignment3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		File csv = new File("/Users/bomeeryu_c/Desktop/csv/Journeys.csv");
		BufferedReader br = new BufferedReader (new FileReader(csv));
		String line = "";
		String str = "";
		while((line = br.readLine()) != null) {
			String[] results = line.split(",",-1);
			for (String output : results ){
				str += output+",";
			}
		       
		      
		 
		    } 
		br.close();
		System.out.println(str);
		}
		catch (FileNotFoundException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		  }
		}

