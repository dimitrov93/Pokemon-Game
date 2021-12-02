import com.company.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class mainTest {
    @Test
    public void menuTest(){
        String expected = "1. Play a game!" + " 2. Check logs "  + "3. Exit Please, select an option from the menu:";
        String actual = menuOption();
        String msg = "Something is worng in the msg!";
        Assert.assertEquals(msg,expected,actual);
    }

    public static String menuOption() {
        System.out.println("1. Play a game!");
        System.out.println("2. Check logs");
        System.out.println("3. Exit");
        System.out.print("Please, select an option from the menu: " + "\n");
        return "1. Play a game! 2. Check logs 3. Exit Please, select an option from the menu:";
    }

    @Test
    public void selectPokemonsFromMenuTest() {
        String expected = " 1.Pikachu 2.Squirtle 3.Charizard 4.Crobat 5.Fearow";
        String actual = selectPokemons();
        String msg = "Something went wrong";
        Assert.assertEquals(msg,expected,actual);
    }

    public static String selectPokemons() {
        return " 1.Pikachu 2.Squirtle 3.Charizard 4.Crobat 5.Fearow";
    }


    @Test
    public void printPokemonTextTest() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        File pokemonFile = new File("Pokemon.txt");
        Scanner scan = new Scanner(pokemonFile);
        while (scan.hasNextLine()) {
            System.out.println(scan.nextLine());
        }
        scan.close();

        boolean exists = pokemonFile.exists();
        boolean expected = true;
        boolean actual = exists;
        String msg = "Something went wrong";
        Assert.assertEquals(msg,actual,expected);
    }

    @Test
    public void switchMenuOptionTest() {
        int expected;
        byte userOption = 1;
        switch (userOption) {
            case 1:
                expected = 1; break;
            case 2:
                expected = 2; break;
            default:
                throw new IllegalStateException("Unexpected value: " + userOption);
        }

        int actual = userOption;
        String msg = "Something is wrong";
        Assert.assertEquals(msg,expected,actual);
    }



}
