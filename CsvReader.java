import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvReader {
	public static void main(String[] args) {
		String csvFile = "C:\\hhuodatasource\\user.csv";
		String line = "";
		String delimiter = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			while ((line = br.readLine()) != null) {
				String[] user = line.split(delimiter);
				System.out.println(user[1] + ", " + user[2]);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
