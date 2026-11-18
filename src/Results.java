public class Results{

    private String functionName;
    private double duration;
    private String sample;

    public Results(double duration, String functionName, String sample) {
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

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    @Override
    public String toString() {
        return "Results{" +
                "functionName='" + functionName + '\'' +
                ", duration=" + duration +
                ", sample='" + sample + '\'' +
                '}';
    }

}
