package ai.iambot.elasticsearch.script.metrics;

public class TSSSMetricProvider implements MetricProvider{
    @Override
    public Metric getMetric(float[] inputVector) {
        return new TSSSMetric(inputVector);
    }
}
