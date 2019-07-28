package test01;

import static org.junit.Assert.*;

import org.junit.Test;

import tirepressuremonitoringsystem.Alarm;

public class AlarmTestCase {

	@Test
	public final void a_normal_pressure_value_should_not_raise_the_alarm() {
		  Alarm target = new Alarm();
          target.check();
          assertFalse(target.isAlarmOn());          
	}

	@Test
	public final void a_pressure_value_out_of_range_should_raise_the_alarm() {
		Alarm target = new Alarm();
        target.check();
        assertTrue(target.isAlarmOn());
	}

	@Test
	public final void a_normal_pressure_value_after_an_out_of_range_pressure_value_should_keep_the_alarm_on() {
		Alarm target = new Alarm();
        target.check();
        assertTrue(target.isAlarmOn());
	}
	
}
