public class Results{

    private String functionName;
    private double duration;
    private int sample;

    public Results(double duration, String functionName, int sample) {
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

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public int getSample() {
        return sample;
    }

    public void setSample(int sample) {
        this.sample = sample;
    }

    @Override
    public String toString() {
        return "Metodo: " + functionName + " | " +
                " Sample: " + sample + " | " + " Duracion: " + duration + " ms";
    }

}
