package tirepressuremonitoringsystem;

public class FakeSensor implements ISensor {
	public double fakeValue = 10;
	@Override
	public double popNextPressurePsiValue() {
		// TODO Auto-generated method stub
		return fakeValue;
	}

}
