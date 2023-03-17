public class Keyboard {
    public final double weight;
    public final boolean illumination;
    public final KeyboardType type; //

    public Keyboard(double weight, boolean illumination, KeyboardType type) {
        this.weight = weight;
        this.illumination = illumination;
        this.type = type;
    }

    public double getWeight() {return weight;}
    public boolean isIllumination() {return illumination;}
    public KeyboardType getType() {return type;}

    public Keyboard setWeight(double weight) {
        return new Keyboard(weight, illumination, type);
    }
    public Keyboard setIllumination(boolean illumination) {
        return new Keyboard(weight, illumination, type);
    }
    public Keyboard setKeyboardType(KeyboardType type) {
        return new Keyboard(weight, illumination, type);
    }
}
