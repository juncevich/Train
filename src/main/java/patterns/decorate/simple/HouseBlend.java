package patterns.decorate.simple;

public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend Cofee";
    }


    public double cost() {
        return .89;
    }
}
