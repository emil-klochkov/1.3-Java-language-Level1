package Ex3;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> countryCapitalMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("countries.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" - ");
                if (parts.length == 2) {
                    countryCapitalMap.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading countries.txt: " + e.getMessage());
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String username = scanner.nextLine();

        int score = 0;
        List<String> countries = new ArrayList<>(countryCapitalMap.keySet());
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            String randomCountry = countries.get(random.nextInt(countries.size()));
            System.out.println("What is the capital of " + randomCountry + "?");
            String userAnswer = scanner.nextLine();

            if (countryCapitalMap.get(randomCountry).equalsIgnoreCase(userAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer is " + countryCapitalMap.get(randomCountry));
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("classificacio.txt", true))) {
            writer.write(username + ": " + score + " points");
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to classificacio.txt: " + e.getMessage());
        }

        System.out.println("Game over! " + username + ", you scored " + score + " points.");
    }
}