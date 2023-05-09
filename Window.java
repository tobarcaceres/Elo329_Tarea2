/**
 * A window with its magnetic sensor.
 */
public class Window {
    public Window(int zone, WindowView view) {
        magneticSensor = new MagneticSensor(zone);
        state = State.CLOSE;
        wView = view;
        wView.addMagneticSensorView(magneticSensor.getView());
        wView.setWindowModel(this);
    }
    public void changeState(State state) {  // is called when this window's view is clicked eventhandler
        switch (state) {
            case CLOSING:
                //this.state=State.OPENING;
                magneticSensor.getView().setOpenView();
                break;
            case OPENING:
                //this.state=State.CLOSING;
                magneticSensor.getView().setOpenView();
                
                break;
        }
    }
    public void finishMovement(State state) { // is called when this window ends closing or opening
        switch (state) {
            case OPEN:
                //this.state=State.OPEN;
                magneticSensor.getView().setOpenView();
                break;
            case CLOSE:
                //this.state=State.CLOSE;
                magneticSensor.getView().setCloseView();
                break;
        }
    }
    public WindowView getView(){
        return wView;
    }
    private final WindowView wView;
    private final MagneticSensor magneticSensor;
    private State state;
}
