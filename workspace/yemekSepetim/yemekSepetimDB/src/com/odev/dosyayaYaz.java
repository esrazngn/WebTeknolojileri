package com.odev;

import java.io.FileWriter;
import java.io.IOException;

public class dosyayaYaz {
	public static void yaz(String jsonString, String path) {
		try {

			FileWriter file = new FileWriter(path);
			file.write(jsonString);
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
