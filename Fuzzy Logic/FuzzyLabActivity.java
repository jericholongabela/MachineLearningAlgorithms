import java.util.Scanner;
public class FuzzyLabActivity {
    public static void main(String[] args) {
        double cloudcover, dom_partly, dom_sunny, dom_overcast;
        double temp, dom_freeze, dom_cool, dom_warm, dom_hot;
        Scanner scan = new Scanner(System.in);


        System.out.print("Enter a temperature in fahrenheit:");
        temp = scan.nextDouble();

        System.out.print("Enter a cloud cover percentage: ");
        cloudcover = scan.nextDouble();

        dom_freeze = freezingTemp(temp);
        dom_cool = coolingTemp(temp);
        dom_warm = warmTemp(temp);
        dom_hot = hotTemp(temp);

        dom_sunny = getSunny(cloudcover);
        dom_partly = getPartly(cloudcover);
        dom_overcast = getOvercast(cloudcover);
        
        System.out.println("\nThe degree of membership results for a temperature of " + Math.round(temp) + "°F are:");
        System.out.println("Freezing is: " + dom_freeze + " or " + (Math.round(dom_freeze * 100)) + "%"
        + "\nCool is: " + dom_cool + " or " + (Math.round(dom_cool * 100)) + "%"
        + "\nWarm is: " + dom_warm + " or " + (Math.round(dom_warm * 100)) + "%"
        + "\nHot is: " + dom_hot + " or " + (Math.round(dom_hot * 100)) + "%");

       
        System.out.println("\nThe degree of membership results for a cloud cover of " + Math.round(cloudcover) + "% are:");
        System.out.println("Sunny Weather Percentage is: " + (Math.round(dom_sunny* 100)+"%"));
        System.out.println("Partly Cloudy Weather Percentage is: " + (Math.round(dom_partly* 100)+"%"));
        System.out.println("Overcast Weather Percentage is: " + (Math.round(dom_overcast* 100)+"%" +"\n"));
        scan.close();
    }
    // functions for temp
    static double freezingTemp (double temp){
        double retval = 0;

        if (temp <= 30) {
            retval = 1;
        }else if ((temp > 30) && (temp <= 50)){
            retval = (-0.05 * temp) + 2.5;
        }else if (temp > 50) {
            retval = 0;
        }

        return retval;
    }

    static double coolingTemp (double temp){
        double retval = 0;

        if ((temp < 30) || temp > 70) {
            retval = 0;
        }else if ((temp >= 30 && temp < 50)){
            retval = (0.05 * temp) + -1.5;
        }else if ((temp >= 50 && temp < 70)) {
            
            retval = (-0.05 * temp) + 3.5;
            
        }

        return retval;
    }

    static double warmTemp (double temp){
        double retval = 0;

        if ((temp < 50) || temp > 90) {
            retval = 0;
        }else if ((temp >= 50 && temp < 70)){
            retval = (0.05 * temp) + -2.5;
        }else if ((temp >= 70 && temp < 90)) {
            
            retval = (-0.05 * temp) + 4.5;
            
        }

        return retval;
    }

    static double hotTemp (double temp){
        double retval = 0;

        if (temp <= 70) {
            retval = 0;
        }else if ((temp > 70 && temp < 90)){
            retval = (0.05 * temp) + -3.5;
        }else if (temp >= 90) {
            retval = 1;
        }

        return retval;
    }
    //functions for cloud
    static double getSunny(double cloudcover){
        double percentage = 0;
        if(cloudcover<=20){
            percentage = 1;
        }else if((cloudcover > 20)&& (cloudcover <= 40)){
            percentage = (-0.05 * cloudcover) + 2;
        }else if (cloudcover > 40){
            percentage = 0;
        }
        
        return percentage;
    }
    static double getPartly(double cloudcover){
        double percentage = 0;
        if((cloudcover < 20 || cloudcover > 80)){
            percentage = 0;
        }else if((cloudcover>=20 && cloudcover <50)){
            percentage = (cloudcover * 0.033333) + -0.66667;
        }else if((cloudcover>= 50 && cloudcover <80)){
            percentage = (cloudcover * -0.03333) + 2.666667;
        }
        return percentage;
    }
    static double getOvercast(double cloudcover){
        double percentage = 0;
        if(cloudcover < 60){
            percentage = 0;
        }else if(cloudcover >= 60 && cloudcover < 80){
            percentage = (cloudcover * 0.05) + -3;
        }else if(cloudcover >= 80){
            percentage = 1;
        }
        return percentage;
    }
}


