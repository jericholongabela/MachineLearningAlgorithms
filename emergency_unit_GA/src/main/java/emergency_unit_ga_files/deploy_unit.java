package emergency_unit_ga_files;

import javafx.scene.chart.XYChart;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class deploy_unit {
    // 10x10km grid -> [location x][location y] = weight
    final static Integer [][] map = {
          // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
/* 0 */     {5, 2, 4, 8, 9, 0, 3, 3, 8, 7},
/* 1 */     {5, 5, 3, 4, 4, 6, 4, 1, 9, 1},
/* 2 */     {4, 1, 2, 1, 3, 8, 7, 8, 9, 1},
/* 3 */     {1, 7, 1, 6, 9, 3, 1, 9, 6, 9},
/* 4 */     {4, 7, 4, 9, 9, 8, 6, 5, 4, 2},
/* 5 */     {7, 5, 8, 2, 5, 2, 3, 9, 8, 2},
/* 6 */     {1, 4, 0, 6, 8, 4, 0, 1, 2, 1},
/* 7 */     {1, 5, 2, 1, 2, 8, 3, 3, 6, 2},
/* 8 */     {4, 5, 9, 6, 3, 9, 7, 6, 5, 10},
/* 9 */     {0, 6, 2, 8, 7, 1, 2, 1, 5, 3}
    };

    // parents -> initialized
    static Integer [] parent_1 = new Integer[2];
    static Integer [] parent_2 = new Integer[2];

    // children -> initialized
    static Integer [] child_1 = new Integer[2];
    static Integer [] child_2 = new Integer[2];

    // fittest -> initialized, fittest_1 is the fittest and fittest_2 is the second fittest
    static Integer [] fittest = new Integer[2];

    // distances -> initialized
    static double cost_P1 = 0;
    static double cost_P2 = 0;
    static double cost_C1 = 0;
    static double cost_C2 = 0;
    static double response_time = 0;

    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter max generation: ");
        int max_generation = scan.nextInt();
        int generation;

        // generate random parents
        generate_random_chromosome(parent_1);
        generate_random_chromosome(parent_2);

        for (generation=0; generation<max_generation; generation++){
            // get cost value
            cost_P1 = get_cost(parent_1);
            cost_P2 = get_cost(parent_2);

            // generate initial child through crossover
            generate_child();
            // mutate child
            mutate_child();
            // get cost value
            cost_C1 = get_cost(child_1);
            cost_C2 = get_cost(child_2);

            // find the fittest and or the second most fit
            select_fittest();

            // save the current fittest value
            get_fittest();

            // display current generation and fitness in chart
            plot_convergence.series.getData().add(new XYChart.Data<>(generation, get_cost(fittest)));

            // display current generation and fittest chromosome in terminal
            display_final_output(generation);
        }
        // display the chart
        plot_convergence.main(null);
    }

    // generate a random chromosome
    public static void generate_random_chromosome (Integer[] input_chromosome){
        Integer[] random_chromosome = new Integer[2];
        Random randomizer = new Random();

        for (int i=0; i<2; i++){
            random_chromosome[i] = randomizer.nextInt(10);
        }

        copy_chromosome(random_chromosome, input_chromosome);
    }

    // generate child -> crossover
    public static void generate_child (){
        child_1[0] = parent_1[0];
        child_1[1] = parent_2[1];

        child_2[0] = parent_2[0];
        child_2[1] = parent_1[1];
    }

    // mutation method
    public static void mutate_child (){
        // mutation rate per gene per chromosome is 50%;
        // total of 100% mutation rate per chromosome;
        // 50 chance if add or subtract 1
        Random randomizer = new Random();
        int mutate_add_or_subtract = randomizer.nextInt(2);
        int mutate_x_c1 = randomizer.nextInt(100);
        int mutate_y_c1 = randomizer.nextInt(100);
        int mutate_x_c2 = randomizer.nextInt(100);
        int mutate_y_c2 = randomizer.nextInt(100);

        // if 0 then +1, if 1 then -1
        if (mutate_add_or_subtract == 0){
            if (mutate_x_c1 < 50){
                // +1 to the x value
                if ((child_1[0] != 9)){
                    child_1[0] = child_1[0] + 1;
                } else {
                    child_1[0] = 0;
                }
            }
            if (mutate_y_c1 < 50){
                // +1 to the x value
                if ((child_1[1] != 9)){
                    child_1[1] = child_1[1] + 1;
                } else {
                    child_1[1] = 0;
                }
            }
            if (mutate_x_c2 < 50){
                // +1 to the x value
                if ((child_2[0] != 9)){
                    child_2[0] = child_2[0] + 1;
                } else {
                    child_2[0] = 0;
                }
            }
            if (mutate_y_c2 < 50){
                // +1 to the x value
                if ((child_2[1] != 9)){
                    child_2[1] = child_2[1] + 1;
                } else {
                    child_2[1] = 0;
                }
            }
        } else {
            if (mutate_x_c1 < 50){
                // +1 to the x value
                if ((child_1[0] != 0)){
                    child_1[0] = child_1[0] - 1;
                } else {
                    child_1[0] = 9;
                }
            }
            if (mutate_y_c1 < 50){
                // +1 to the x value
                if ((child_1[1] != 0)){
                    child_1[1] = child_1[1] - 1;
                } else {
                    child_1[1] = 9;
                }
            }
            if (mutate_x_c2 < 50){
                // +1 to the x value
                if ((child_2[0] != 0)){
                    child_2[0] = child_2[0] - 1;
                } else {
                    child_2[0] = 9;
                }
            }
            if (mutate_y_c2 < 50){
                // +1 to the x value
                if ((child_2[1] != 0)){
                    child_2[1] = child_2[1] - 1;
                } else {
                    child_2[1] = 9;
                }
            }
        }
    }

    // cost function
    public static double get_cost (Integer[] chromosome){
        // cost = summation( Weight*(sqrt( (bx-ax)^2 + (by-ay)^2))) from n=1 to n=100
        // cost -> initially zero
        double cost = 0;

        // i -> y, j -> x
        for (int i=0; i<10; i++){
            for (int j=0; j<10; j++){
                cost += map[i][j] * (Math.sqrt( Math.pow((j-chromosome[0]), 2) + Math.pow((i-chromosome[1]), 2)));
            }
        }

        return cost;
    }

    // getting the response time
    public static double get_response_time (){
        // response time (minutes) = 1.7 + 3.4 * r
        // r -> summation(sqrt( (bx-ax)^2 + (by-ay)^2))) / 100
        double response_time = 0;

        // i -> y, j -> x
        for (int i=0; i<10; i++){
            for (int j=0; j<10; j++){
                response_time += (Math.sqrt( Math.pow((j-fittest[0]), 2) + Math.pow((i-fittest[1]), 2)));
            }
        }

        response_time /= 100;

        response_time = 1.7 + 3.4 * response_time;

        return response_time;
    }

    // selecting the fittest
    public static void select_fittest (){
        // determine which child has the shorter distance
        if (cost_P1 < cost_P2) { // if (distanceP1 < distanceP2) = distanceP1
            if (cost_C1 < cost_C2) { // if (distanceC1 < distanceC2) = distanceC1
                if (cost_P1 < cost_C2) { // distanceP1 < distanceC1
                    // generate new parent 2
                    generate_random_chromosome(parent_2);
                } else { // if distanceP1 > distanceC1
                    // parent 2 -> child 1
                    copy_chromosome(child_1, parent_2);
                }
            } else { // if (distanceC1 < distanceC2) = distanceC2
                if (cost_P1 < cost_C2) { // distanceP1 < distanceC2
                    // generate new parent 2
                    generate_random_chromosome(parent_2);
                } else { // if distanceP1 > distanceC2
                    // parent 2 -> child 2
                    copy_chromosome(child_2, parent_2);
                }
            }
        } else { // if (distanceP1 < distanceP2) = distanceP2
            if (cost_C1 < cost_C2) { // if (distanceC1 < distanceC2) = distanceC1
                if (cost_P2 < cost_C1) { // distanceP2 < distanceC1
                    // generate new parent 1
                    generate_random_chromosome(parent_1);
                } else { // if distanceP2 > distanceC1
                    // parent 1 -> child 1
                    copy_chromosome(child_1, parent_1);
                }
            } else { // if (distanceC1 < distanceC2) = distanceC2
                if (cost_P2 < cost_C2) { // distanceP2 < distanceC2
                    // generate new parent 1
                    generate_random_chromosome(parent_1);
                } else { // if distanceP1 > distanceC2
                    // parent 1 -> child 2
                    copy_chromosome(child_2, parent_1);
                }
            }
        }
    }

    // getting the fittest -> fittest []
    public static void get_fittest (){
        if (get_cost(parent_1) < get_cost(parent_2)){
            copy_chromosome(parent_1, fittest);
        } else {
            copy_chromosome(parent_2, fittest);
        }
    }

    // copy one chromosome to another
    public static void copy_chromosome (Integer[] source, Integer[] destination){
        for (int i=0; i<2; i++){
            destination[i] = source[i];
        }
    }

    // for the display of the final output
    public static void display_final_output (int generation){
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        System.out.println("Generation: " + (generation+1) + "\t\t" + " x: " + fittest[0] + "\t y: " + fittest[1]+
                "\t\t Cost: " + get_cost(fittest) + "\t\t Response time (mins): " + df.format(get_response_time()) );
    }
}
