package ai.iambot.elasticsearch.script.metrics;

public class ChiSquaredMetricProvider implements MetricProvider{
    @Override
    public Metric getMetric(float[] inputVector) {
        return new ChiSquaredMetric(inputVector);
    }
}
