package tirepressuremonitoringsystem;

public class Alarm
{
    public static final double LowPressureThreshold = 17;
    public static final double HighPressureThreshold = 21;

    private ISensor sensor = null;

    private boolean alarmOn = false;

    public Alarm(){
    	sensor = new SensorAdapter();
    }
    
    public Alarm(ISensor s){
    	sensor = s;
    }
    
    public void check()
    {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        //业务逻辑---20行代码 
        ////
        //最后进行
        if (psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue)
        {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}
