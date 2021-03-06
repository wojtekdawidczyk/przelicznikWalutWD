package dodatkowe;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PobierzKursy1 {

	public static void main(String[] args) {
		
		try {
			URL url = new URL("http://api.nbp.pl/api/exchangerates/tables/A");
			
			try(InputStream strumien = url.openStream()) {
				Files.copy(strumien, Paths.get("kursy.json"), StandardCopyOption.REPLACE_EXISTING);
				System.out.println("Gotowe");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
