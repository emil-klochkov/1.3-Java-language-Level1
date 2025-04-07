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
        Collections.shuffle(countries); // Mezcla aleatoriamente la lista

        int totalQuestions = Math.min(10, countries.size()); // Por si hay menos de 10 países

        for (int i = 0; i < totalQuestions; i++) {
            String randomCountry = countries.get(i); // Ya está mezclado, así que no se repite
            System.out.println("What is the capital of " + randomCountry + "?");
            String userAnswer = scanner.nextLine();

            if (countryCapitalMap.get(randomCountry).equalsIgnoreCase(userAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer is " + countryCapitalMap.get(randomCountry));
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("clasification.txt", true))) {
            writer.write(username + ": " + score + " points");
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to clasification.txt: " + e.getMessage());
        }

        System.out.println("Game over! " + username + ", you scored " + score + " points.");
    }
}