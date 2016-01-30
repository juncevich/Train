package patterns.decorate.simple;

public class Decaf extends Beverage{
    public Decaf(){
        description ="Decafeined";
    }

    public double cost() {
        return 1.05;
    }
}
