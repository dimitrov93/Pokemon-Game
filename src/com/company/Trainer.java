package com.company;

import java.util.Scanner;

public class Trainer {
    String trainerName;

    public  void trainerName() {
        Scanner in=new Scanner(System.in);
        System.out.print("Trainer, enter your name: ");
        trainerName = in.nextLine();
    }
}
