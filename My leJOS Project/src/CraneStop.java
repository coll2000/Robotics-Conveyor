import lejos.hardware.Sound;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.NXTRegulatedMotor;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;
import lejos.robotics.subsumption.Behavior;

public class CraneStop implements Behavior {
	
	private NXTRegulatedMotor crane;
	
	private CurrentSample current;
	
	private EV3ColorSensor cs;
	
	public CraneStop(NXTRegulatedMotor crane, CurrentSample current, EV3ColorSensor cs) {
		this.crane = crane;
		this.current = current;
		this.cs = cs;
	}
	@Override
	public boolean takeControl() {
		if(cs.getColorID() != Color.BLUE | current.getDistance() <= 0.06) {
			return true;
		}
		return false;
	}

	@Override
	public void action() {
		//crane.stop();
		crane.stop();
		//Sound.beepSequence();
		//current.getSort().stop(); //Stops the current arbitrator
	}

	@Override
	public void suppress() {

	}

}
