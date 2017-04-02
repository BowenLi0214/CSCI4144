import java.util.Locale;

public class normalization {
	 public static double normalize(double input, double min, double max)
	    {
	        return (input-min)/(max-min);
	    }
	    public static double scale(double input, double min, double max)
	    {
	        return min + input * (max-min);
	    }
	    public static double DoNormalize(double input,double MaxIn,double min, double max)
	    {
	        double minIn = 0.0;
	        double maxIn = MaxIn;
	        double minOut = min;
	        double maxOut = max;
	       
            double alpha = normalize(input, minIn, maxIn);
            double output = scale(alpha, minOut, maxOut);
            return output;
	    } 

}
