package patterns.betabox;

public class BeatController implements ControllerInterface {
    BeatModelInterface model;
    DJView view;

    public BeatController(BeatModelInterface model) {
        this.model = model;

        view = new DJView(this, model);
        // Создается вид.
        view.createView();
        //Создаются контроллеры.
        view.createControls();
        //Отключается пункт СТОП в меню.
        view.disableStopMenuItem();
        //Включается пункт СТАРТ в меню.
        view.enableStartMenuItem();
        //Инициализируется модель.
        model.initialize();
    }

    public void start() {
        model.on();
        view.disableStartMenuItem();
        view.enableStopMenuItem();
    }

    public void stop() {
        model.off();
        view.disableStopMenuItem();
        view.enableStartMenuItem();
    }

    public void increaseBPM() {
        int bpm = model.getBPM();
        model.setBPM(bpm + 1);
    }

    public void decreaseBPM() {
        int bpm = model.getBPM();
        model.setBPM(bpm - 1);
    }

    public void setBPM(int bpm) {
        model.setBPM(bpm);
    }
}
