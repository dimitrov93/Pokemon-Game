package com.company;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    static String trainerName;
    static int crystals;
    static ArrayList<Pokemon>yourChoose=new ArrayList<>();
    static ArrayList<Pokemon>enemyChoose=new ArrayList<>();
    public static void main(String[] args) {


        MyPokemon ourPokemon = new MyPokemon();
        EnemyPokemon enemyPokemon = new EnemyPokemon();

        YourAttacks yourAttacks=new YourAttacks();
        EnemyAttacks enemyAttacks=new EnemyAttacks();


        printPokemonChars();
        menuOption();
        switchMenuOptions(ourPokemon,enemyPokemon,yourAttacks,enemyAttacks);


    }

    private static void printPokemonChars() {
        try {
            printPokemonText();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void playTheGame(MyPokemon ourPokemon, EnemyPokemon enemyPokemon,YourAttacks yourAttacks,EnemyAttacks enemyAttacks) {
        Scanner scanner = new Scanner(System.in);
        trainerName();
        System.out.println(trainerName + " - Welcome to the tournament!");

        System.out.println("Select your pokemons:" + selectPokemons());
        ourPokemon.choosePokemonInBattle();
        ourPokemon.printMyPokemons();

         enemyPokemon.randomEnemyPokemonInBattle();
        enemyPokemon.printEnemyPokemon();
        printLine();
        int roundCounter = 1;
        System.out.println("The battle begins");
        System.out.println("Choose pokemon to play with: ");
        yourChoose= ourPokemon.youChooseOnePokemon();
        System.out.print("Enemy player choose: ");
        enemyChoose= enemyPokemon.enemyChoosePokemon();
        crystals = 0;
        loop: while(enemyPokemon.enemyPokemonList.size()!=0 || ourPokemon.myPokemon.size()!=0 || roundCounter <= 5){
             int healthBar = ourPokemon.yourChoose.get(0).HP;

             while (true) {  // while 2 start
                printLine();
                roundCounter(roundCounter);
                printLine();
                if (roundCounter % 2 != 0) {
                    enemyAttacks.AbilityChoice(yourChoose,enemyChoose);
                    if (yourChoose.get(0).HP <= 0 ) {
                        System.out.println(ourPokemon.yourChoose.get(0).name + " is dead");
                        yourChoose.get(0).HP = healthBar;
                        ourPokemon.removedPokemon.add(yourChoose.get(0));
                        ourPokemon.myPokemon.remove(yourChoose.get(0));
                        yourChoose.remove(0);

                        if (ourPokemon.myPokemon.size() <= 0&&crystals<10) {
                            break loop;
                        } else if (ourPokemon.myPokemon.size() <= 0&&crystals > 10) {
                                System.out.println("Do you want to resurrect a pokemon? ");
                                System.out.println("1-Yes");
                                System.out.println("2-No");
                                int n=scanner.nextInt();
                                switch(n){
                                    case 1:
                                        yourChoose=ourPokemon.youChooseOnePokemon();
                                        crystals = 0;
                                        break;
                                    case 2:
                                        System.out.println("Have a great day!");
                                        break loop;


                                }
                            }
//                                ourPokemon.returnPokemon();
//                                crystals = 0;
                        else{
                            yourChoose=ourPokemon.youChooseOnePokemon();
                            roundCounter++;
                            break;
                          }

                    }

                } else {
                    System.out.println("Press 1 for attack choice");
                    System.out.println("Press 2 for new pokemon");
                    int choice=scanner.nextInt();
                    switch (choice){
                        case 1:
                           yourAttacks.AbilityChoice(yourChoose,enemyChoose);
                            break ;
                        case 2:
                            yourChoose.remove(0);
                            yourChoose= ourPokemon.youChooseOnePokemon();
                            System.out.println("Choice attack!");
                            yourAttacks.AbilityChoice(yourChoose,enemyChoose);
                            break;
                    }

                }
                 if (enemyChoose.get(0).HP <= 0) {
                     System.out.println(enemyPokemon.enemyChoose.get(0).name + " is dead");
                     enemyChoose.remove(0);
                     crystals += randomCrystalGenerator() ;
                     if (enemyPokemon.enemyPokemonList.size() <= 0)  {
                         System.out.println("All enemy pokemons are dead.");
                         break loop;
                     } else  {
                         System.out.print("Enemy player choose: ");
                         enemyChoose= enemyPokemon.enemyChoosePokemon();
                         roundCounter++;
                         System.out.println("Crystals amount: " + crystals);
                         continue;
                     }

                 }
                roundCounter++;
            } // while 2 end
            System.out.println("Crystals amount: " + crystals);
        } // while 1 end

        printLine();
        whoWins(ourPokemon);
    }

    public static void menuOption() {
        System.out.println("1. Play a game!");
        System.out.println("2. Check logs");
        System.out.println("3. Exit");
        System.out.print("Please, select an option from the menu: " + "\n");
    }

    public static void switchMenuOptions (MyPokemon ourPokemon, EnemyPokemon enemyPokemon,YourAttacks yourAttacks,EnemyAttacks enemyAttacks) {
        Scanner scanner = new Scanner(System.in);
        byte userOption = scanner.nextByte();
        switch (userOption) {
           case 1 -> playTheGame(ourPokemon, enemyPokemon,yourAttacks,enemyAttacks);
           case 2 -> winnerReader(ourPokemon, enemyPokemon,yourAttacks,enemyAttacks);
            default -> System.out.println("Have a great day!");
        }
    }

    private static void whoWins(MyPokemon ourPokemon) {
        String winner;
        if (ourPokemon.myPokemon.size() <= 0) {
            System.out.println("The enemy wins!");
            winner = "The enemy";
        } else {
            System.out.println(trainerName + " you win!");
            winner = trainerName;
        }

        winnerWritter(winner);
    }

    private static void winnerWritter(String winner) {
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

    private static void winnerReader(MyPokemon ourPokemon, EnemyPokemon enemyPokemon,YourAttacks yourAttacks,EnemyAttacks enemyAttacks) {
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

        menuOption();
        switchMenuOptions(ourPokemon,enemyPokemon,yourAttacks,enemyAttacks);
    }

    private static void roundCounter(int roundCounter) {
        if (roundCounter % 2 != 0) {
            System.out.println("Round: " + roundCounter + " - Enemy attack!");
        } else {
            System.out.println("Round: " + roundCounter + " - You attack!");
        }
    }

    public static void printPokemonText() throws FileNotFoundException {
        File pokemonFile = new File("Pokemon.txt");
        Scanner scan = new Scanner(pokemonFile);
        while (scan.hasNextLine()) {
            System.out.println(scan.nextLine());
        }
        scan.close();
    }

    public static void trainerName() {
        Scanner in = new Scanner(System.in);
        System.out.print("Trainer, enter your name: ");
        trainerName = in.nextLine();
    }

    public static String selectPokemons() {

        return " 1.Pikachu 2.Squirtle 3.Charizard 4.Crobat 5.Fearow";
    }

    public static void printLine() {
        System.out.println();
    }

    public static int randomCrystalGenerator() {
        Random rand = new Random();
        int randomCrystal = rand.nextInt(20)+1;
        return randomCrystal;
    }
}
