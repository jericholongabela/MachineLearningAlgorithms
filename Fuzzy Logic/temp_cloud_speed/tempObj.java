public class tempObj {
    double getFreezing (double temp){
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

    double getCool (double temp){
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

    double getWarm (double temp){
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

    double getHot (double temp){
        double retval = 0;

        if (temp <= 70) { retval = 0;
        }else if ((temp > 70 && temp < 90)){
            retval = (0.05 * temp) + -3.5;
        }else if (temp >= 90) {
            retval = 1;
        }

        return retval;
    }
}
