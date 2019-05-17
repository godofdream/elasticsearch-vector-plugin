package ai.iambot.elasticsearch.script.metrics;

public class DotMetricProvider implements MetricProvider{
    @Override
    public Metric getMetric(float[] inputVector) {
        return new DotMetric(inputVector);
    }
}
