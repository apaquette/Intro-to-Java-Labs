
import java.text.NumberFormat;

/**
 * Compensation Model interface declaration
 * @author <a href="mailto:alexandre.d.paquette@gmail.com">Alexandre Paquette</a>
 * @version Apr 7, 2022
 */
public interface CompensationModel {
    public final NumberFormat nf = NumberFormat.getCurrencyInstance();
    
    public abstract double earnings();
    public abstract String getCompensationModelName();
}
