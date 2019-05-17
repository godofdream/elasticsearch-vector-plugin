package ai.iambot.elasticsearch.script.metrics;

public class TSSSMetric implements Metric{
    float[] inputVector;
    public TSSSMetric(float[] inputVector){
        this.inputVector = inputVector;
    }

    @Override
    public float metric(float[] queryVector) {
        return TSSSHelper.TS_SS(this.inputVector, queryVector);
    }
}
