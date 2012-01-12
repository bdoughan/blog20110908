package blog.weather;
 
import org.eclipse.persistence.oxm.annotations.XmlPath;
 
public class Forecast {
 
    @XmlPath("day_of_week/@data")
    private String dayOfTheWeek;
 
    @XmlPath("low/@data")
    private int low;
 
    @XmlPath("high/@data")
    private int high;
 
    @XmlPath("condition/@data")
    private String condition;
 
}
