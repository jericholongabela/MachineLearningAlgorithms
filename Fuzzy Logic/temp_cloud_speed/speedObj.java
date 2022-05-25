public class speedObj {
    double arrRule1 [];
    double arrRule2 [];
    double arrAgg [];
    
    double getSpeedFast(int speed){
        double dom_fast = 0;
        if(speed<=25){
            dom_fast = 0;
        }else if((speed > 25)&& (speed <= 75)){
            dom_fast = (0.02 * speed) + -0.5;
        }else if (speed > 75){
            dom_fast = 1;
        }
        
        return dom_fast;
    }

    double getSpeedSlow(int speed){
        double dom_slow = 0;
        if(speed<=25){
            dom_slow = 1;
        }else if((speed > 25)&& (speed <= 75)){
            dom_slow = (-0.02 * speed) + 1.5;
        }else if (speed > 75){
            dom_slow = 0;
        }
        
        return dom_slow;
    }
}

/*
    R1[i] = min(getDOMFast(i),Max_rule1);

    int i;

    for each i{
        dom_fast = getDOMFast(i);
        R1[i] = min(dom_fast, max_rule1);
        i++;
    }

    R2[i] = min(getDOMFast(i),Max_rule2);

    int i;

    for each i{
        dom_fast = getDOMSlow(i);
        R2[i] = min(dom_fast, max_rule1);
        i++;
    }

    Agg[i] = max(R1[i],R2[i]);

    for each i {
        Agg[i] = max(R1[i],R2[i]);
        i++;
    }
*/
