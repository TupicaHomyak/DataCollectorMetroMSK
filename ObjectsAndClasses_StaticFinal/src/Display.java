public class Display {
    public final double diagonal;
    public final double weight;
    public final DisplayType type; //IPS, TN, VA

    public Display(double diagonal, double weight, DisplayType type) {
        this.diagonal = diagonal;
        this.weight = weight;
        this.type = type;
    }

    public double getDiagonal() {return diagonal;}
    public double getWeight() {return weight;}
    public DisplayType getType() {return type;}

    public Display setDiagonal(double diagonal) {
        return new Display(diagonal, weight, type);
    }
    public Display setWeight(double weight) {
        return new Display(diagonal, weight, type);
    }
    public Display setDisplayType(DisplayType type) {
        return new Display(diagonal, weight, type);
    }
}
