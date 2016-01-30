package patterns.remotecontrol;

public class CeilingFanHighCommand implements Command {
    CailingFan ceilingFan;
    int prevSpeed;

    public CeilingFanHighCommand(CailingFan cailingFan) {
        this.ceilingFan = cailingFan;
    }

    public void execute() {
        ceilingFan.getSpeed();
        ceilingFan.high();
    }

    @Override
    public void undo() {
        if (prevSpeed == CailingFan.HIGH) {
            ceilingFan.high();
        } else if (prevSpeed == CailingFan.MEDIUM) {
            ceilingFan.medium();
        } else if (prevSpeed == CailingFan.LOW) {
            ceilingFan.low();
        } else if (prevSpeed == CailingFan.OFF) {
            ceilingFan.off();
        }
    }
}
