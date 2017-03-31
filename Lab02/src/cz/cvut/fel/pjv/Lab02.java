/*
 * File name: Lab06.java
 * Date:      2014/08/26 21:39
 * Author:    @author
 */

package cz.cvut.fel.pjv;

import java.util.*;

public class Lab02 {



    public void start(String[] args) {
        if(args.length > 0) {
            if(args[0].equals("1") || args[0].equals("2") || args[0].equals("3") || args[0].equals("4")) {
                return;
            }
        }
        homework();
    }

    private void homework() {
        TextIO textIO = new TextIO();

        int lineNumber = 0;

        String line = textIO.getLine();
        lineNumber++;

        double[] numbers = new double[10];
        int storedNumbers = 0;

        while(!line.equals("")){
            String[] lines = line.split(" ");
            boolean invalidNumber = false;

            for(String element : lines){
                    if(TextIO.isDouble(element)){
                        numbers[storedNumbers] = Double.parseDouble(element);
                        storedNumbers++;
                    } else {
                        System.err.printf("A number has not been parsed from line %d\n", lineNumber);
                        invalidNumber = true;
                        break;
                    }
            }

            if(invalidNumber){
                line = textIO.getLine();
                lineNumber++;
                continue;
            }

            if(storedNumbers == 10){
                System.out.printf("%2d %.3f %.3f\n", 10, getMean(numbers, storedNumbers), getDeviation(numbers, storedNumbers));
                storedNumbers = 0;
            }

            line = textIO.getLine();
            lineNumber++;
        }

        System.out.println("End of input detected!");
        if(storedNumbers > 1){
            System.out.printf("%2d %.3f %.3f\n", storedNumbers, getMean(numbers, storedNumbers), getDeviation(numbers, storedNumbers));
        }
    }

    private double getMean(double[] array, int storedNumbers){
        double mean = 0;

        for(int i = 0; i < storedNumbers; i++){
            mean += array[i];
        }

        return mean/(storedNumbers);
    }

    private double getDeviation(double[] array, int storedNumbers){
        double mean = getMean(array, storedNumbers);
        double tmp = 0;


        for(int i = 0; i < storedNumbers; i++){
            tmp += (array[i] - mean)*(array[i] - mean);
        }

        return Math.sqrt(tmp/(storedNumbers));
    }
}

/* end of Lab02.java */
