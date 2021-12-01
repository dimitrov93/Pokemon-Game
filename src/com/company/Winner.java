package com.company;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Winner{
    String winner;

    public void whoWins(YourTeam yourTeam,Trainer trainer) {

        if (yourTeam.myPokemon.size() <= 0) {
            System.out.println("The enemy wins!");
            this.winner = "The enemy";
        } else {
            System.out.println(trainer.trainerName + " you win!");
            this.winner = trainer.trainerName;
        }

        winnerWriter(winner);
    }

    public void winnerWriter(String winner) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        File date = new File("winner.txt");
        try {
            FileWriter fw = new FileWriter(date.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(dtf.format(now) + " --- The winner is: " + winner + "\n");
            bw.close();
            fw.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }

    public void winnerReader(){
        try {
            File winner = new File("winner.txt");
            Scanner myReader = new Scanner(winner);
            while (myReader.hasNextLine()) {
                System.out.println(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error in reading");
            e.printStackTrace();
        }
    }
}