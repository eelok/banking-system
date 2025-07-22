package com.petrius.banking_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingSystemApplication.class, args);
//
//		String filePath = "/Users/petrius/Desktop/SchynigePlatte1.md";
//options 1
//		try {
//			FileReader fileReader = new FileReader(filePath);
//			int character = fileReader.read();
//			while (character != -1 ){
//				System.out.print((char) character);
//				character = fileReader.read();
//			}
//
//			fileReader.close();
//		} catch (FileNotFoundException e){
//			System.out.println("Datei nicht gefunden! Überprüfe den Namen und Pfad.");
//		} catch (IOException e){
//			System.out.println(e.getMessage());
//		}
//options 2
//		try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
//			String line;
//			while ((line = reader.readLine()) != null){
//				System.out.println(line);
//			}
//		}catch (IOException e){
//			System.out.println(e.getMessage());
//		}

    }
}
