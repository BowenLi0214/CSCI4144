import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import com.sun.java.swing.plaf.windows.resources.windows_es;

class OpenOB {

	String[][] lines;

	public String[][] getLines() {
		return lines;
	}

	int blankLines = 0;

	public int getBlankLines() {
		return blankLines;
	}

	public void setBlankLines(int blankLines) {
		this.blankLines = blankLines;
	}

	int index = 0;

	Scanner scanner = new Scanner(System.in);

	void loadDB() throws FileNotFoundException {

		String FileName = new String();
		int string_rows = 0;
		int string_colomn = 0;

		System.out.println("input the path of file");
		//FileName = scanner.nextLine();
		FileName = "wine.data";
		File file = new File(FileName);
		Scanner input = new Scanner(file);

		while (input.hasNextLine()) {

			String[] currentLine = input.nextLine().replaceAll("( )+", " ").split(",");

			if (Arrays.toString(currentLine).equals("[]")) {
				blankLines++;
			}

			index++;
		}

		lines = new String[index][];
		System.out.println("blank lines: " + blankLines);

		input.close();
		input = null;
		input = new Scanner(file);

		while (input.hasNextLine()) {
			lines[string_rows] = input.nextLine().replaceAll("( )+", " ").split(",");
			string_rows++;
		}
	}

	void showDB() {
		System.out.println("lines row :" + lines.length);
		System.out.println("lines colomn :" + lines[0].length);

		for (int row = 0; row < lines.length - blankLines; row++) {
			for (int column = 0; column < lines[0].length; column++)
				System.out.print(lines[row][column] + "\t");

			System.out.println("");
		}

	}

	void showDBRow(int row_number) {
		for (int column = 0; column < lines[0].length; column++) {
			System.out.print(lines[row_number][column] + "\t");
		}

		System.out.println("");
	}

	void showDBElement(int row_number, int colomn_number) {
		System.out.println(lines[row_number][colomn_number]);
	}

	String getDBElement(int row_number, int colomn_number) {
		return lines[row_number][colomn_number];
	}

}
