package com.oocl.mnlbc.db;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Config Class
 * 
 * @author Group 1
 * 
 *@since 2016-07-11
 *
 */
public class Config {

	   /**
	    * Gets value from config file
	    * 
	    * @return String
	    */
	   public static String getConfigValue(String property) {
	      String value = "";
	      try {
	         // FileReader reader = new FileReader(configFile);
	         InputStream stream = Config.class.getClassLoader().getResourceAsStream("config.properties");
	         Properties props = new Properties();
	         props.load(stream);
	         value = props.getProperty(property);
	         stream.close();
	         // reader.close();
	      } catch (FileNotFoundException ex) {
	         System.out.println("File not found");
	      } catch (IOException ex) {
	         System.out.println("Invalid input");
	      }
	      return value;

	   }
	}