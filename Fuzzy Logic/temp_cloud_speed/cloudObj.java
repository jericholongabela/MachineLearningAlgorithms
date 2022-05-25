public class cloudObj {
    double getSunny(double cloudcover){
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
    double getPartly(double cloudcover){
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
    double getOvercast(double cloudcover){
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
