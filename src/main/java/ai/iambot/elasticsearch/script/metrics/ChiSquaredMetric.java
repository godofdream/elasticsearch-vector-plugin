package ai.iambot.elasticsearch.script.metrics;

public class ChiSquaredMetric implements Metric{
    float[] inputVector;
    float epsilon = 1e-10;
    public ChiSquaredMetric(float[] inputVector){
        this.inputVector = inputVector;
    }

    @Override
    public float metric(float[] queryVector) {
        float result = 0.0;
        for (int i = 0; i < queryVector.length; i++) {
            double diff = queryVector[i]-this.inputVector[i];
            result += (diff * diff)/(queryVector[i]+inputVector[i]+epsilon);
        }
        return 0.5 * result;
    }
}
