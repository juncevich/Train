package patterns.remotecontrol;

public interface Command {
    void execute();
    void undo();
}
