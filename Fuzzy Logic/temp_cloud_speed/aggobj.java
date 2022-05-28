public class aggobj {
    void aggragate(double speed_r1, double speed_r2){
        double maxr1 = speed_r1;
        double maxr2 = speed_r2;

        double[] r1 = new double[101];
        double[] r2 = new double[101];
        double[] agg = new double[101];

        getr1(maxr1, r1);
        getr2(maxr2, r2);

        /**Display speed- r1- r2 */
        System.out.println("Speed - R1 - R2");
        for(int i=0;i<101;i++){
            System.out.printf("%d - %.4f - %.4f%n", i, r1[i], r2[i]);
        }

        /**aggragate array r1 and r2 by getting the max value for each array */
        for(int i=0;i<101;i++){
            if(r1[i]>r2[i]){
                agg[i] = r1[i];
            }
            else{
                agg[i]  =r2[i];
            }
        }

        getcentroid(agg);

    }
    /*this funtion will assign value to 101 array include [0] of r1*/
    void getr1(double maxr1, double[] r1){
        for(int i=0;i<101;i++){
            if(i<=25){
                r1[i] = 0;
            }
            else{
                r1[i] = 0.02 * i + -0.5; /*multiple by the linear equation of fast */
                if(r1[i]>maxr1){    /*if value exceed 0.5, it will clip it to 0.5 */
                    r1[i] = maxr1;
                }
            }
        }
    }
    void getr2(double maxr2, double[] r2){
        for(int i=0;i<101;i++){
            if(i<=25){
                r2[i] = maxr2;
            }
            if(i>25 || i<75){
                r2[i] = -0.02 * i + 1.5; /*multiple by the linear equation of slow */
                if(r2[i]>maxr2){ /**if vaalue exceed max r2, clip to value of max r2 */
                    r2[i] = maxr2;
                }
            }
            if(i>74){
                r2[i] = 0;
            }
            
        }
    }
    void getcentroid(double[] agg){

        double[] product = new double[101];
        double sum_agg = 0, sum_product = 0, centroid;

        /**multiply speed to agg value 1 by 1 and assign to product */
        for(int i=0;i<101;i++){
            product[i] = i * agg[i];
        }
        System.out.printf("%n%n");
        System.out.println("Speed - Aggregate = Product");
        for(int i=0;i<101;i++){
            /*System.out.println(i + " - " + agg[i] + " = " + product[i]);*/
            System.out.printf("%d - %.4f = %.4f%n", i, agg[i], product[i]);
        }


        /**add all the value of product and assign to sum_product */
        for(int i=0;i<101;i++){
            sum_product += product[i];
        }
        System.out.printf("Total Product of Speed and Aggregated R1,R2: %.4f %n", sum_product);

        /**sum of aggregated r1 AND r2*/
        for(int i=0;i<101;i++){
            sum_agg += agg[i];
        }
        /*System.out.println("Total Aggregated R1,R2: " +sum_agg);*/
        System.out.printf("Total Aggregated R1,R2: %.4f %n", sum_agg);

        /**compute centroid */
        centroid = sum_product/sum_agg;
        System.out.printf("Centroid: %.4f %n", centroid);
    }
}
