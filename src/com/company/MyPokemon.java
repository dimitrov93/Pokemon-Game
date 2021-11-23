package com.company;

import java.util.*;

//public class MyPokemon extends Pokemon  implements YourAbility {
public class MyPokemon extends Pokemon  {
    Pokemon[]pokemon;
    ArrayList<Pokemon>myPokemon=new ArrayList<>();
    Scanner scanner=new Scanner(System.in);


    public MyPokemon(){
        this.pokemon=new Pokemon[5];
        pokemon[0]=new Pokemon("Pikachu","Electric","Medium",35,55,40);
        pokemon[1]=new Pokemon("Squirtle","Aqual","Small",55,48,65);
        pokemon[2]=new Pokemon("Charizard","Flame","Big",78,84,78);
        pokemon[3]=new Pokemon("Crobat","Flying","Small",85,90,80);
        pokemon[4]=new Pokemon("Fearow","Flying","Medium",65,90,65);

        for(int i=0;i<5;i++){
            if(pokemon[i].size.equals("Small")){
                pokemon[i].HP=(int)(pokemon[i].HP-(pokemon[i].HP*0.2));
                pokemon[i].AP=(int)(pokemon[i].AP-(pokemon[i].AP*0.2));
                pokemon[i].DP=(int)(pokemon[i].DP-(pokemon[i].DP*0.2));
            }else if(pokemon[i].size.equals("Big")){
                pokemon[i].HP=(int)(pokemon[i].HP+(pokemon[i].HP*0.2));
                pokemon[i].AP=(int)(pokemon[i].AP+(pokemon[i].AP*0.2));
                pokemon[i].DP=(int)(pokemon[i].DP+(pokemon[i].DP*0.2));
            }
        }
    }


    public ArrayList<Pokemon> choosePokemonInBattle(){
        Scanner scanner=new Scanner(System.in);
        int count=0;
        while (count<3){
            int n=scanner.nextInt();
            myPokemon.add(pokemon[n-1]);
            count++;
        }
        return myPokemon;
    }
    public void printMyPokemons() {
        System.out.println("Your pokemons are: ");
        for (int i = 0; i < 3; i++) {
            System.out.println(myPokemon.get(i));
        }
    }

    public ArrayList<Pokemon> youChooseOnePokemon(){
        for (int i = 0; i < myPokemon.size(); i++) {
            System.out.println((i + 1) + ":" + myPokemon.get(i).name);
        }
        int choice=scanner.nextInt();

        switch (choice){
            case 1:
                yourChoose.add(0,myPokemon.get(0)) ;
                System.out.println("Your Pokemon is: "+yourChoose.get(0).name);
                break;
            case 2:
                yourChoose.add(0,myPokemon.get(1)) ;
                System.out.println("Your Pokemon is: "+yourChoose.get(0).name);
                break;
            case 3:
                yourChoose.add(0,myPokemon.get(2)) ;
                System.out.println("Your Pokemon is: "+yourChoose.get(0).name);
                break;
        }
        return yourChoose;
    }

    public void returnPokemon() {
        for (int i = 0; i < removedPokemon.size(); i++) {
            System.out.println((i + 1) + ":" + removedPokemon.get(i));
        }

        int choice = scanner.nextInt();
        myPokemon.add(myPokemon.size()-1,removedPokemon.get(choice-1));
        removedPokemon.remove(removedPokemon.get(choice-1));
    }

//    @Override
//    public int lowAbility() {
//        return (int) (yourChoose.get(0).AP + (yourChoose.get(0).AP * 0.2));
//    }
//
//    @Override
//    public int mediumAbility() {
//        return (int) (yourChoose.get(0).AP + (yourChoose.get(0).AP * 0.3));
//    }
//
//    @Override
//    public int highAbility() {
//        return (int) (yourChoose.get(0).AP + (yourChoose.get(0).AP * 0.4));
//    }
//
//    @Override
//    public void youUseShield() {
//
//    }
}
