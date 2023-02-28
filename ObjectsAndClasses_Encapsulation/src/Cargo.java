public class Cargo { //иммутабельный класс для хранения информации о грузах
    private final Dimensions dimensions; //габариты - класс
    private final int weight; //масса
    private final String deliveryAddress; //адрес доставки
    private final boolean allowedToFlip; //можно ли переворачивать
    private final String number; //регистрационный номер
    private final boolean breakable; //является ли груз хрупким
    public Cargo(Dimensions dimensions, int weight, String deliveryAddress, //констр
                 boolean allowedToFlip, String number, boolean breakable) {
        this.dimensions = dimensions;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.allowedToFlip = allowedToFlip;
        this.number = number;
        this.breakable = breakable;
    }
    public Dimensions getDimensions() {return dimensions;}
    public int getWeight() {
        return weight;
    }
    public String getDeliveryAddress() {
        return deliveryAddress;
    }
    public boolean getAllowedToFlip() {
        return allowedToFlip;
    }
    public String getNumber() {
        return number;
    }
    public boolean getBreakable() {
        return breakable;
    }

    public Cargo setDimensions(Dimensions dimensions) {
        return new Cargo(dimensions, weight, deliveryAddress, allowedToFlip, number, breakable);
    }
    public Cargo setWeight(int weight) {
        return new Cargo(dimensions, weight, deliveryAddress, allowedToFlip, number, breakable);
    }
    public Cargo setDeliveryAddress(String deliveryAddress) {
        return new Cargo(dimensions, weight, deliveryAddress, allowedToFlip, number, breakable);
    }
    public Cargo setAllowedToFlip(boolean allowedToFlip) {
        return new Cargo(dimensions, weight, deliveryAddress, allowedToFlip, number, breakable);
    }
    public Cargo setNumber(String number) {
        return new Cargo(dimensions, weight, deliveryAddress, allowedToFlip, number, breakable);
    }
    public Cargo setBreakable(boolean breakable) {
        return new Cargo(dimensions, weight, deliveryAddress, allowedToFlip, number, breakable);
    }

    public String toString() { //
        return " габариты: " + dimensions + "; \n "
                + "объем груза с учетом габаритов: " + dimensions.volume() + "; \n "
                + "масса: " + weight + "; \n "
                + "адрес доставки: " + deliveryAddress + "; \n "
                + "можно ли переворачивать: " + allowedToFlip + "; \n "
                + "регистрационный № " + number + "; \n "
                + "хрупкость: " + breakable+ ".";
    }
}