package patterns.remotecontrol;

public class Light {
    public Light(String name) {
        System.out.println(name);
    }

    public void on() {
        System.out.println("Light is On");
    }

    public void off() {
        System.out.println("Light is Off");
    }
}
