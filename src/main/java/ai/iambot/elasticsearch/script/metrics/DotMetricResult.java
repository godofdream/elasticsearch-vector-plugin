package ai.iambot.elasticsearch.script.metrics;

public class DotMetricResult {
    float queryVectorNorm;
    float dot;
    public DotMetricResult(float queryVectorNorm, float dot){
        this.queryVectorNorm = queryVectorNorm;
                this.dot = dot;
    }

    public float getQueryVectorNorm() {
        return queryVectorNorm;
    }

    public float getDot() {
        return dot;
    }
}
