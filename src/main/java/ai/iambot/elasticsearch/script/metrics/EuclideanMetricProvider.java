package ai.iambot.elasticsearch.script.metrics;

public class EuclideanMetricProvider implements MetricProvider{
    @Override
    public Metric getMetric(float[] inputVector) {
        return new EuclideanMetric(inputVector);
    }
}
