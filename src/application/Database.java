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

	public static final String DELIMITER = ";";

	public static final String DATABASE_FILE = "database.txt";

	public static final String[] COLUMNS = new String[] { "Date and Time", "Addressee", "Subject", "Message" };

	public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

	public static void addRecord(Date date, String mail, String subject, String message) {
		StringBuilder sb = new StringBuilder();
		sb.append(DATE_FORMAT.format(date)).append(DELIMITER);
		sb.append(mail).append(DELIMITER);
		sb.append(subject).append(DELIMITER);
		sb.append(message);

		try {
			FileWriter fileWriter = new FileWriter(getDatabaseFile(), true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			bufferedWriter.write(sb.toString()); // zapisali v fail
			bufferedWriter.newLine(); // dobavili simvil novoj stroki

			bufferedWriter.flush();
			bufferedWriter.close();
		} catch (Exception e) {
			// do nothing
		}
	}

	private static File getDatabaseFile() {
		File file = new File(DATABASE_FILE);

		if (!file.exists()) { // esli net faila sozdat fail
			try {
				file.createNewFile();
			} catch (IOException e) {
			}
		}

		return file;
	}

	public static List<DatabaseRecord> getRecords() {
		List<DatabaseRecord> records = new ArrayList<>(); // delaem pustoj

		BufferedReader br = null;
		try {
			FileReader fileReader = new FileReader(getDatabaseFile());
			br = new BufferedReader(fileReader);

			String line = "";
			// chitaem po strokam fail
			while ((line = br.readLine()) != null) {
				// razbivaem po ;
				String[] fields = line.split(DELIMITER);

				// sozdajom zapis bazy dannyh. mapim fields na polja
				DatabaseRecord record = new DatabaseRecord();
				record.setDate(DATE_FORMAT.parse(fields[0]));
				record.setEmail(fields[1]);
				record.setSubject(fields[2]);
				record.setMessage(fields[3]);

				// dobavljaem etu zapis k spisku zapisej
				records.add(record);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException ignore) {
				}
			}
		}

		return records;
	}

}
