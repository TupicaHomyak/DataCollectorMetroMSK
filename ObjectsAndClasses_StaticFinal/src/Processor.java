public class Processor {
    public final double frequency;
    public final int cores;
    public final double weight;
    public final String manufacturer;

    public Processor(double frequency, int cores, double weight, String manufacturer) {
        this.frequency = frequency;
        this.cores = cores;
        this.weight = weight;
        this.manufacturer = manufacturer;
    }
    public double getFrequency() {return frequency;}
    public int getCores() {return cores;}
    public double getWeight() {return weight;}
    public String getManufacturer() {return manufacturer;}

    public Processor setFrequency(double frequency) {
        return new Processor(frequency, cores, weight, manufacturer);
    }
    public Processor setCores(int cores) {
        return new Processor(frequency, cores, weight, manufacturer);
    }
    public Processor setWeight(double weight) {
        return new Processor(frequency, cores, weight, manufacturer);
    }
    public Processor setManufacturer(String manufacturer) {
        return new Processor(frequency, cores, weight, manufacturer);
    }
}
