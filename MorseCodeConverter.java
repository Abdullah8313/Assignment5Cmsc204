/*
 * Name: Abdullah Nabeel
 * CMSC:204-Assignment 5
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter
{
	static MorseCodeTree mct = new MorseCodeTree();

	public MorseCodeConverter()
	{
		mct=null;
	}//constructor

	public static String convertToEnglish(File codeFile)throws FileNotFoundException
	{
		// File file = new File("C:\\Users\\pankaj\\Desktop\\test.txt");

//		  BufferedReader br = new BufferedReader(new FileReader(codeFile));
//
//		  String st;
//		  try{
//		  while ((st = br.readLine()) != null){
//		    System.out.println(st);
//		  }
//		  }
//		  catch(Exception e)
//		  {
//
//		  }
		Scanner scnr = new Scanner(new FileInputStream(codeFile));
		//Scanner scnr1 = new Scanner(new FileInputStream(FILE_NAME1));
		String ss="";
		while (scnr.hasNextLine())
		{
			ss=ss+scnr.nextLine();
			System.out.println(ss);
		}

		scnr.close();
		return convertToEnglish(ss);
	}//method

	public static String convertToEnglish(String code)
	{
		String[] arrOfStr = code.split("/");
		String hh="";
        for (String a : arrOfStr){
        	String[] arrOfStr1 = a.split(" ");
        	//System.out.println(a);
        	for(String b:arrOfStr1){
        		if(b.equals("")||b.equals(" ") || b==null)
        		{
        			continue;
        		}
        		String h= mct.fetch(b);
        		hh=hh+h;



        	}
        	hh=hh+" ";
        	System.out.println("Convert: "+hh);
        }
        System.out.println("Converts: "+hh);
		return hh.substring(0,hh.length()-1);
	}//method

	public static String printTree()
	{
		String s1="";
		ArrayList<String> s = mct.toArrayList();
		String ss = null;
		for(int i=0; i<s.size(); i++){
			ss = s.get(i);
			if(s.size()==i-1)
			s1=s1+ss;
			else
				s1=s1+ss+" ";
		}
		return s1;
	}//method

	public void readFile(File input) throws FileNotFoundException
	{
		Scanner scnr = new Scanner(new FileInputStream(input));
		String ss="";
		while (scnr.hasNextLine())
		{
			ss=ss+scnr.nextLine();
		}
		scnr.close();
	}//method

}//end class MorseCodeConverter
