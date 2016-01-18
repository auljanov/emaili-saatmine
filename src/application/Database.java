package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Database {

	// constants creating
	public static final String DELIMITER = ";"; 

	public static final String DATABASE_FILE = "database.txt";

	public static final String[] COLUMNS = new String[] { "Date and Time", "Addressee", "Subject", "Message" };

	public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

	public static void addRecord(Date date, String mail, String subject, String message)  
	{
		StringBuilder stringbuilder = new StringBuilder(); // Create object in class Database
		stringbuilder.append(DATE_FORMAT.format(date)).append(DELIMITER);
		stringbuilder.append(mail).append(DELIMITER);
		stringbuilder.append(subject).append(DELIMITER);
		stringbuilder.append(message);

		try {
			FileWriter fileWriter = new FileWriter(getDatabaseFile(), true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			bufferedWriter.write(stringbuilder.toString()); // Write to file
			bufferedWriter.newLine(); // Add character off new line

			bufferedWriter.flush();
			bufferedWriter.close();
		} catch (Exception e) {
			// do nothing
		}
	}

	private static File getDatabaseFile() {
		File file = new File(DATABASE_FILE);

		if (!file.exists()) { // if the file is missing, create it
			try {
				file.createNewFile();
			} catch (IOException e) {
			}
		}

		return file;
	}

	public static List<DatabaseRecord> getRecords() {
		List<DatabaseRecord> records = new ArrayList<>(); // an empty file

		BufferedReader bufferedreader = null;
		try { // do stuff
			FileReader fileReader = new FileReader(getDatabaseFile());
			bufferedreader = new BufferedReader(fileReader);

			String line = "";
			// read the file line by line
			while ((line = bufferedreader.readLine()) != null) {
				// after reading split lines by delimiter
				String[] fields = line.split(DELIMITER);

				// create a record in the database and fields mapping
				DatabaseRecord record = new DatabaseRecord();
				record.setDate(DATE_FORMAT.parse(fields[0]));
				record.setEmail(fields[1]);
				record.setSubject(fields[2]);
				record.setMessage(fields[3]);

				// add record to other records
				records.add(record);
			}
		} 

		catch (Exception e) // handle e
		{
			e.printStackTrace();
		} 

		finally // always executed, even if exception or error 
		{ 
			if (bufferedreader != null) 
			{
				try 
				{
					bufferedreader.close();
				} catch (IOException ignore) {

				}
			}
		}

		return records;
	}

}
