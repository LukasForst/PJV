package cz.cvut.fel.pjv;

/*
 * Created by lukas on 22.2.17.
 * first lab homework
 */

import java.util.Scanner;

public class Lab01 {

    public void start(String[] args) {
        homework();
    }

    public void homework() {
        String[] a_text = {"Zadej scitanec: ", "Zadej mensenec: ", "Zadej cinitel: ", "Zadej delenec: "};
        String[] b_text = {"Zadej scitanec: ", "Zadej mensitel: ", "Zadej cinitel: ", "Zadej delitel: "};

        System.out.println("Vyber operaci (1-soucet, 2-rozdil, 3-soucin, 4-podil):");

        Scanner sc = new Scanner(System.in);

        int usrChoice = sc.nextInt() - 1;
        if (usrChoice > 3 || usrChoice < 0) {
            System.out.println("Chybna volba!");
            return;
        }

        System.out.println(a_text[usrChoice]);
        double a = sc.nextDouble();

        System.out.println(b_text[usrChoice]);
        double b = sc.nextDouble();
        if (usrChoice == 3 && b == 0) {
            System.out.println("Pokus o deleni nulou!");
            return;
        }

        System.out.println("Zadej pocet desetinnych mist: ");
        int fieldSize = sc.nextInt();
        if (fieldSize < 0) {
            System.out.println("Chyba - musi byt zadane kladne cislo!");
            return;
        }

        String eleFormat = "%." + fieldSize + "f";
        String[] format = {
                eleFormat + " + " + eleFormat + " = " + eleFormat,
                eleFormat + " - " + eleFormat + " = " + eleFormat,
                eleFormat + " * " + eleFormat + " = " + eleFormat,
                eleFormat + " / " + eleFormat + " = " + eleFormat
        };

        double[] result = {a+b , a-b , a*b, a/b};

        System.out.printf(format[usrChoice] + "\n", a, b, result[usrChoice]);
    }
}