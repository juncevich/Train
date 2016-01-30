package patterns.gumbalmachine;

public class WinnerState {
    GumballMachine gumballMachine;

    public void insertQuarter() {
        System.out.println("Please wait, we're already giving you a gumball.");
    }

    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank.");
    }

    public void turnCrank() {
        System.out.println("Turning twice doesn't get you another gumball!");
    }

    public void dispense(){
        System.out.println("YOU'RE A WINNER ! You get two gumballs for you quarter");
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() > 0 ){
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
            System.out.println("Oops, out of gumballs!");
            gumballMachine.setState(gumballMachine.getSoldState());
        }

    }
}
