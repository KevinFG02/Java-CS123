package Week10.Takehome.weather;

/**
 * Represents a single year of annual weather data recorded at
 * Seattle-Tacoma International Airport.
 *
 * This class is complete. Do not modify it.
 */
public class WeatherRecord {
    private double avgTempF;
    private double precipIn;
    private int daysWithRain;
    private int daysAbove90F;
    private int maxTempF;

    /**
     * Constructs a WeatherRecord with all five annual measurements.
     *
     * @param avgTempF    mean annual temperature in degrees Fahrenheit
     * @param precipIn    total annual precipitation in inches
     * @param daysWithRain number of days with measurable precipitation
     * @param daysAbove90F number of days where the high reached 90F or above
     * @param maxTempF    highest temperature recorded that year in degrees Fahrenheit
     */
    public WeatherRecord(double avgTempF, double precipIn, int daysWithRain,
                         int daysAbove90F, int maxTempF) {
        this.avgTempF     = avgTempF;
        this.daysWithRain  = daysWithRain;
        this.precipIn      = precipIn;
        this.daysAbove90F  = daysAbove90F;
        this.maxTempF      = maxTempF;
    }

    public double getAvgTempF()    { return avgTempF; }
    public double getPrecipIn()    { return precipIn; }
    public int getDaysWithRain()   { return daysWithRain; }
    public int getDaysAbove90F()   { return daysAbove90F; }
    public int getMaxTempF()       { return maxTempF; }

    @Override
    public String toString() {
        return String.format(
                "avg=%.1fF, precip=%.1fin, rainDays=%d, days>=90F=%d, maxTemp=%dF",
                avgTempF, precipIn, daysWithRain, daysAbove90F, maxTempF
        );
    }
}