package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {
	public static String readDataFromPropertyFile(String path,String key) {
		File file=new File(path);
		Properties propFile=new Properties();
		String data=null;
		
		try {
			FileInputStream fi = new FileInputStream(file);
			propFile.load(fi);
			data=propFile.getProperty(key,"");
			fi.close();
			
		}catch(FileNotFoundException e) {
			System.out.println("---error in file path---");
			e.printStackTrace();
			}catch(IOException e) {
				System.out.println("---err while loading prop file---");
				e.printStackTrace();
			}
		return data;
	}

}
