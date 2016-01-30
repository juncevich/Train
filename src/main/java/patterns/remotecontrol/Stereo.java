package patterns.remotecontrol;

public class Stereo {
    public void on() {
        System.out.println("Light is On");
    }

    public void off() {
        System.out.println("Stereo is Off");
    }



    public void setVolume(int i){
        System.out.println("Volume is " + i);
    }
}