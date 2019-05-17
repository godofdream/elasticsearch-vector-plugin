package ai.iambot.elasticsearch.script.metrics;

public class CosineMetricProvider implements MetricProvider{
    @Override
    public Metric getMetric(float[] inputVector) {
        return new CosineMetric(inputVector);
    }
}
