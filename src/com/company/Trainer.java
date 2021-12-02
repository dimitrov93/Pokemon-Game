package com.company;

import java.util.Scanner;

public class Trainer {
    String trainerName;

    public  String trainerName() {
        Scanner in=new Scanner(System.in);
        System.out.print("Trainer, enter your name: ");
        this.trainerName = in.next();
        return trainerName;
    }
}
