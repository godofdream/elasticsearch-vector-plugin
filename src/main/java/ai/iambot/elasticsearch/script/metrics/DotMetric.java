package ai.iambot.elasticsearch.script.metrics;

public class DotMetric implements Metric{
    protected final float inputVectorMagnitude;
    protected final float[] inputVector;
    public DotMetric(float[] inputVector){
        this.inputVectorMagnitude = TSSSHelper.VectorSize(inputVector);
        this.inputVector = inputVector;
    }

    @Override
    public float metric(float[] queryVector) {
        DotMetricResult result = dotMetric(queryVector);
        return result.getDot();
    }

    public DotMetricResult dotMetric(float[] queryVector) {
        float queryVectorNorm = 0.0;
        float dotProduct = 0.0;
        for (int i = 0; i < queryVector.length; i++) {
            queryVectorNorm += Math.pow(queryVector[i], 2);
            dotProduct += queryVector[i] * inputVector[i];
        }
        return new DotMetricResult(Math.sqrt(queryVectorNorm), dotProduct);
    }
}
