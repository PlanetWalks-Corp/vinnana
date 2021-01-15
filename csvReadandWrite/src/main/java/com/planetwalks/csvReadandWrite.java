package com.planetwalks;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.List;

public class csvReadandWrite {
	public static String userLoc = "Files/user.csv";
	public static int users = 0;

	public static void writeData(User user) throws InterruptedException {
		Thread write = new Thread(() ->{
			try{
				FileWriter fw = new FileWriter(userLoc, true);
				CSVWriter writer = new CSVWriter(fw);
				String[] data = {user.getFirstName(), user.getLastName(), user.getAddress()};

				writer.writeNext(data);
				writer.close();
				System.out.println("Successful");

			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		});
		write.start();
		write.join();
	}

	public static void readData() throws InterruptedException {
		Thread read = new Thread(() -> {
			try {
				FileReader fr = new FileReader(userLoc);
				CSVReader reader = new CSVReaderBuilder(fr).build();

				List<String[]> data = reader.readAll();
				System.out.println("First Name | Last Name | Address|");
				for(String[] row: data){
					for(String cell: row){
						System.out.print(cell + "|\t");
					}
					System.out.println();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		read.start();
		read.join();
	}

	public static void main(String[] args) throws IOException, InterruptedException {

		InputStreamReader r=new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(r);
		String input;
		while(true){
			User user = new User();
			System.out.println("Enter \n1. Writing\n2. Reading\n3. exit");
			input = in.readLine();

			if(Integer.parseInt(input) == 1){
				System.out.println("Enter first name");
				user.setFirstName(in.readLine());

				System.out.println("Enter last name");
				user.setLastName(in.readLine());

				System.out.println("Enter your address");
				user.setAddress(in.readLine());

				writeData(user);
			}
			else if(Integer.parseInt(input) == 2){
				readData();
			}
			else if(Integer.parseInt((input)) == 3){
				break;
			}
			else{
				System.out.println("Invalid Input");
			}
		}

	}
}
