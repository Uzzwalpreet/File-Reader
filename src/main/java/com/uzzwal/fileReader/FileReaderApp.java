package com.uzzwal.fileReader;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.uzzwal.fileReader.service.FileLoader;

@SpringBootApplication
@Configuration
public class FileReaderApp {

	public static void main(String[] args) throws JsonProcessingException {

		System.out.println("Start");
		FileLoader.getData();
		// for each works on key and set
		FileLoader.dataEntry.forEach((key, entry) -> {
			System.out.println("Key " + key);
			System.out.println("Record:: " + entry.toString());
			if (key.equals("uzzwalsandhu17@gmail.com"))
				entry.setName("namechanged");
		});
		System.out.println("End");
		//FileLoader.getData();
		FileLoader.dataEntry.forEach((key, entry) -> {
			System.out.println("Key " + key);
			System.out.println("And its record:: " + entry.toString());
		});
	}

}
