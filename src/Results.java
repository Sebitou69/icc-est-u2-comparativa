public class Results{

    private String functionName;
    private long duration;
    private int sample;

    public Results(long duration, String functionName, int sample) {
        this.duration = duration;
        this.functionName = functionName;
        this.sample = sample;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public int getSample() {
        return sample;
    }

    public void setSample(int sample) {
        this.sample = sample;
    }

    public double getDurationMs() {
        return duration / 1_000_000.0;
    }

    @Override
    public String toString() {
        return "Metodo: " + functionName + " | " +
                " Sample: " + sample + " | " + " Duracion: " + getDurationMs() + " ms";
    }

}
