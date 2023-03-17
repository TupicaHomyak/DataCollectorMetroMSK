public class Hdd {
    public final double weight;
    public final int memory;
    public final HddType type; //HDD, SSD

    public Hdd(double weight, int memory, HddType type) {
        this.weight = weight;
        this.memory = memory;
        this.type = type;
    }

    public double getWeight() { return weight;}
    public int getMemory() {return memory;}
    public HddType getType() {return type;}

    public Hdd setDiagonal(int memory) {
        return new Hdd(weight, memory, type);
    }
    public Hdd setWeight(double weight) {
        return new Hdd(weight, memory, type);
    }
    public Hdd setHddType(HddType type) {
        return new Hdd(weight, memory, type);
    }
}
