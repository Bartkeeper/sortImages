package sortImages;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Main {

	static File dirYearF = null;
	static File dirYearMonthF = null;
	static String dirYearMonthS = null;
	static File dirNew2 = null;
	// static int year1;
	// static int year2;

	public static String getPath() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Bitte den Pfad des Quellordners angeben:");
		String path = input.nextLine();
		return path;
	}

	public static int getOldestYear() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Bitte das Aufnahmejahr des ältesten Bilds eingeben:");
		String oldestYear = input.nextLine();
		int year1 = Integer.parseInt(oldestYear);
		return year1;
	}

	public static int getLatestYear() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Bitte das Aufnahmejahr des neuesten Bilds eingeben:");
		String latestYear = input.nextLine();
		int year2 = Integer.parseInt(latestYear);
		return year2;
	}

	public static String getSeparator() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Bitte das Zeichen (z.B. '/';'-';'G';'_') vor dem Zeitstempel des Dateinamens eintragen:");
		String separator = input.nextLine();
		return separator;
	}

	public static void createYears(int year1, int year2, File file, String separator, File dir) throws IOException {
		// int year = year1;
		while (year1 <= year2) {
			if (file.getName().contains(separator + year1)) {
				String dirYear = dir + "/" + year1 + "/";
				File dirYearF = new File(dirYear);
				if (dirYearF.exists() == false) {
					dirYearF.mkdirs();
					createMonths(dir, year1, file, separator);
				} else {
					createMonths(dir, year1, file, separator);
				}
			} else {
				year1++;
			}
		}
	}

	public static void createMonths(File dir, int year1, File file, String separator) throws IOException {
		// Erstellen der Jahres-und Monatsordner, falls nicht vorhanden
		int i = 1;
		while (i <= 12) {
			String month = String.format("%02d", i); // führende Nullen bei int
			String dirYearMonthS = dir + "/" + year1 + "/" + month + "/";
			File dirYearMonthF = new File(dirYearMonthS); // erzeugt Zielpfad
			String dirNew = dirYearMonthS + file.getName(); // gibt Pfad + Dateinamen zurück
			dirNew2 = new File(dirNew);
			if (file.getName().contains(separator + year1 + month)) {
				if (dirYearMonthF.exists()) { // prüft, ob der Zielpfad schon existiert
					Files.copy(file.toPath(), dirNew2.toPath(), StandardCopyOption.REPLACE_EXISTING);
					i = i+1;
				} else {
					dirNew2.mkdirs();
					Files.copy(file.toPath(), dirNew2.toPath(), StandardCopyOption.REPLACE_EXISTING);
					i++;
				}
			}else {
				i++;
			}
		}					
	}

	public static void copyFile(File file, File dirNew2) throws IOException {
		if (dirNew2.exists()) {
			Files.copy(file.toPath(), dirNew2.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} else {
			dirNew2.mkdirs();
			Files.copy(file.toPath(), dirNew2.toPath(), StandardCopyOption.REPLACE_EXISTING);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File dir = new File(getPath());
		int year1 = getOldestYear();
		int year2 = getLatestYear();
		String separator = getSeparator();

		Collection<String> files = new ArrayList<String>();

		if (dir.isDirectory()) {
			File[] listFiles = dir.listFiles();

			for (File file : listFiles) {
				if (file.isFile()) {
					files.add(file.getName());

					createYears(year1, year2, file, separator, dir);
					// copyFile(file, dirNew2);

					// doShit(dirYearMonthF, getOldestYear(), file, dir);
				}

				// file.delete();
			}
		}

	}
}
