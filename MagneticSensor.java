public class MagneticSensor extends Sensor {
    public MagneticSensor(int z){
        super(z);
        view = new MagneticSensorView();
    }
    public void setSensorOpen() {
        super.setState(SwitchState.OPEN); //HP:Tobar
    }
    public void setSensorClose() {
        super.setState(SwitchState.CLOSE); //HP:Tobar
    }
    
    public MagneticSensorView getView(){ return view;}
    private final MagneticSensorView view;
}
