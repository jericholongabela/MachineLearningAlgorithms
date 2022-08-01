package emergency_unit_ga_files;

public class row {
        int generation;
        int x;
        int y;
        double cost;
        double response_time;

        String gen, strX, strY, strCost, strRT;

    public row(int generation, int x, int y, double cost, double response_time) {
        this.generation = generation;
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.response_time = response_time;
    }

    public row(String gen, String strX, String strY, String strCost, String strRT) {
        this.gen = gen;
        this.strX = strX;
        this.strY = strY;
        this.strCost = strCost;
        this.strRT = strRT;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getResponse_time() {
        return response_time;
    }

    public void setResponse_time(double response_time) {
        this.response_time = response_time;
    }

    public String getGenerationToString (){
        String convert;
        convert = String.valueOf(generation);
        return convert;
    }

    public String getXToString (){
        String convert;
        convert = String.valueOf(x);
        return convert;
    }

    public String getYToString (){
        String convert;
        convert = String.valueOf(y);
        return convert;
    }

    public String getCostToString (){
        String convert;
        convert = String.valueOf(cost);
        return convert;
    }

    public String getResponseTimeToString (){
        String convert;
        convert = String.valueOf(response_time);
        return convert;
    }
}
