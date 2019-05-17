package ai.iambot.elasticsearch.script.metrics;

public class EuclideanMetric implements Metric{
    float[] inputVector;
    public EuclideanMetric(float[] inputVector){
        this.inputVector = inputVector;
    }

    @Override
    public float metric(float[] queryVector) {
        return TSSSHelper.Euclidean(this.inputVector, queryVector);
    }
}
