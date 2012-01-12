package blog.weather;
 
import java.util.List;
import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlPath;
 
@XmlRootElement(name="xml_api_reply")
@XmlType(propOrder={"location", "currentCondition", "currentTemperature", "forecast"})
@XmlAccessorType(XmlAccessType.FIELD)
public class WeatherReport {
 
    @XmlPath("weather/forecast_information/city/@data")
    private String location;
 
    @XmlPath("weather/current_conditions/temp_f/@data")
    private int currentTemperature;
 
    @XmlPath("weather/current_conditions/condition/@data")
    private String currentCondition;
 
    @XmlPath("weather/forecast_conditions")
    private List<Forecast> forecast;
 
}