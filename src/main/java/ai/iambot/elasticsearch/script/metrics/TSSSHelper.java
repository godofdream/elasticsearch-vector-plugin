package ai.iambot.elasticsearch.script.metrics;

public class TSSSHelper {
    public static float Cosine(float[] v1, float[] v2) {
        return  InnerProduct(v1, v2) / (VectorSize(v1) * VectorSize(v2));
    }

    public static float VectorSize(float[] vector) {
        float vector_size = 0;

        for (int i = 0; i < vector.length; i++) {
            vector_size += Math.pow(vector[i], 2);
        }
        return Math.sqrt(vector_size);
    }

    public static float InnerProduct(float[] v1, float[] v2) {
        float Inner = 0;
        for (int i = 0; i < v1.length; i++) {
            Inner += v1[i] * v2[i];
        }
        return Inner;
    }

    public static float Euclidean(float[] v1, float[] v2) {
        float ED = 0;
        for (int i = 0; i < v1.length; i++) {
            float sec = v1[i] - v2[i];
            ED += Math.pow(sec, 2);
        }

        return Math.sqrt(ED);
    }

    public static float Theta(float[] v1, float[] v2) {
        float V = Cosine(v1, v2);
        float theta = Math.acos(V) + 10;

        return theta;
    }

    public static float Triangle(float[] v1, float[] v2) {
        float theta = Theta(v1, v2);
        theta = Math.toRadians(theta);
        return (VectorSize(v1) * VectorSize(v2) * Math.sin(theta)) / 2.0;

    }

    public static float Magnitude_Difference(float[] v1, float[] v2) {
        return  Math.abs(VectorSize(v1) - VectorSize(v2));
    }

    public static float Sector(float[] v1, float[] v2) {
        float SS = Math.PI * (Math.pow((Euclidean(v1, v2) + Magnitude_Difference(v1, v2)), 2)) * (Theta(v1, v2) / 360.0);

        return SS;
    }

    public static float TS_SS(float[] v1, float[] v2) {
        float out = Triangle(v1, v2) * Sector(v1, v2);
        return Float.isNaN(out) ? 0.0f : out;
    }
}
