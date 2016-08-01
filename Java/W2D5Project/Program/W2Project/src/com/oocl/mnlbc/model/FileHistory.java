package com.oocl.mnlbc.model;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.oocl.mnlbc.dao.CommandDAOImpl;

/**
 * This class is used to generate the history file.
 * 
 * @author Group 1
 *
 */
public class FileHistory {

	FileWriter writer;
	CommandDAOImpl cmd;
	File file;

	/*
	 * Class contructor.
	 */
	public FileHistory() {
		cmd = new CommandDAOImpl();
	}

	/**
	 * Method to create the file.
	 */
	public void createFile() {
		try {
			DateFormat df = new SimpleDateFormat("dd-MM-YYYY");
			Date dateobj = new Date();
			String currentDate = df.format(dateobj);
			file = new File(currentDate + ".txt");
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Puts the history from the database to the file created.
	 */
	public void importHistory() {
		FileWriter writer = null;
		try {
			writer = new FileWriter(file);
			List<History> histList = cmd.getHistory();
			StringBuffer sb = new StringBuffer();
			for (History history : histList) {
				String entry = history.getDateCreated() + " - " + history.getChatterName() + ": "
						+ history.getMessage();
				sb.append(entry + "\n");
			}
			System.out.println("Successfully Generated!");
			writer.append(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (!writer.equals(null)) {
				try {
					writer.flush();
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
