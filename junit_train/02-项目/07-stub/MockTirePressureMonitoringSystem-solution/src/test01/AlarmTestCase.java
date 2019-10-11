package test01;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import tirepressuremonitoringsystem.Alarm;
import tirepressuremonitoringsystem.FakeSensor;
import tirepressuremonitoringsystem.ISensor;

public class AlarmTestCase {

	FakeSensor sensor = null;
	
	@Before
	public void setUp(){
		sensor = new FakeSensor();
	}
	
	@Test
	public final void a_normal_pressure_value_should_not_raise_the_alarm() {
		  sensor.fakeValue = Alarm.LowPressureThreshold + 1;
		  Alarm target = new Alarm(sensor);
          target.check();
          assertFalse(target.isAlarmOn());          
	}

	@Test
	public final void a_pressure_value_out_of_range_should_raise_the_alarm() {
		sensor.fakeValue = Alarm.LowPressureThreshold - 1;
		Alarm target = new Alarm(sensor);
        target.check();
        assertTrue(target.isAlarmOn());
	}

	@Test
	public final void a_normal_pressure_value_after_an_out_of_range_pressure_value_should_keep_the_alarm_on() {
		sensor.fakeValue = Alarm.HighPressureThreshold + 1;
		Alarm target = new Alarm(sensor);
        target.check();
        assertTrue(target.isAlarmOn());
	}
	
}
