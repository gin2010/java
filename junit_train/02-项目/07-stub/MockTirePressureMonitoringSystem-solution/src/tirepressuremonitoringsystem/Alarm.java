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

        //ҵ���߼�---20�д��� 
        ////
        //������
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
