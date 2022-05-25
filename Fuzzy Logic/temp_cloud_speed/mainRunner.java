import java.util.Scanner;
import java.lang.Math;

public class mainRunner {
    public static void main (String[] args) {
        double cloudcover, dom_partly, dom_sunny, dom_overcast, temp, dom_freeze, dom_cool, dom_warm, dom_hot, dom_fast, dom_slow, r1_max, r2_max;
        tempObj domTemp = new tempObj();
        cloudObj domCloud = new cloudObj();
        speedObj domSpeed = new speedObj();
        Scanner scan = new Scanner(System.in);
        int speed = 60;

        System.out.print("Enter a temperature in fahrenheit: ");
        temp = scan.nextDouble();

        System.out.print("Enter a cloud cover percentage: ");
        cloudcover = scan.nextDouble();

        scan.close();

        dom_freeze = domTemp.getFreezing(temp);
        dom_cool = domTemp.getCool(temp);
        dom_warm = domTemp.getWarm(temp);
        dom_hot = domTemp.getHot(temp);

        dom_sunny = domCloud.getSunny(cloudcover);
        dom_partly = domCloud.getPartly(cloudcover);
        dom_overcast = domCloud.getOvercast(cloudcover);

        dom_fast = domSpeed.getSpeedFast(speed);
        dom_slow = domSpeed.getSpeedSlow(speed);

        r1_max = getR1Max(dom_warm, dom_sunny);
        r2_max = getR2Max(dom_partly, dom_cool);
/*        
        System.out.println("\nThe degree of membership results for a temperature of " + Math.round(temp) + "°F are:");
        System.out.println("Freezing is: " + dom_freeze + " or " + (Math.round(dom_freeze * 100)) + "%"
        + "\nCool is: " + dom_cool + " or " + (Math.round(dom_cool * 100)) + "%"
        + "\nWarm is: " + dom_warm + " or " + (Math.round(dom_warm * 100)) + "%"
        + "\nHot is: " + dom_hot + " or " + (Math.round(dom_hot * 100)) + "%");

       
        System.out.println("The degree of membership results for a cloud cover of " + format(cloudcover) + "% are:");
        System.out.println("Sunny Weather Percentage is: " + (format(dom_sunny))+"%");
        System.out.println("Partly Cloudy Weather Percentage is: " + (format(dom_partly)+"%"));
        System.out.println("Overcast Weather Percentage is: " + (format(dom_overcast)+"%") +"\n");
*/
        System.out.println("Fast minimum is " + r1_max + " with a dom_warm of " + dom_warm + ", dom_sunny of "+ dom_sunny);
        System.out.println("Slow minimum is " + r2_max + " with a dom_partly of " + dom_partly + ", dom_cool of "+ dom_cool);

        System.out.println("DOM of fast is "+ dom_fast+ " with a speed of "+speed);
        System.out.println("DOM of slow is "+ dom_slow+ " with a speed of "+speed);
    }
    
    /*
    * formats double values into percentage value
    * @param DOM in 0-1 value
    * @returns percentage value
    */
    static double format(double value){
        return value = Math.round(value * 100);
    }

    /*
    * @param dom_warm, dom_sunny
    * @returns minimum of dom_warm, dom_sunny
    */
    static double getR1Max(double dom_warm, double dom_sunny){
        return Math.min(dom_warm, dom_sunny);
    }

    /*
    * @param dom_partly, dom_cool
    * @returns minimum of dom_partly, dom_cool
    */
    static double getR2Max(double dom_partly, double dom_cool){
        return Math.min(dom_partly, dom_cool);
    }
}


