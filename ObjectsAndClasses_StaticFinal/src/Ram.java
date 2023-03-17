public class Ram {
    public final double weight;
    public final int volume;
    public final RamType type; //

    public Ram(double weight, int volume, RamType type) {
        this.weight = weight;
        this.volume = volume;
        this.type = type;
    }
    public double getWeight() {return weight;}
    public int getVolume() {return volume;}
    public RamType getType() {return type;}


    public Ram setWeight(double weight) {
        return new Ram(weight, volume, type);
    }
    public Ram setVolume(int volume) {
        return new Ram(weight, volume, type);
    }
    public Ram setRamType(RamType type) {
        return new Ram(weight, volume, type);
    }
}