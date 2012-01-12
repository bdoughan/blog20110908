package blog.weather;
 
import java.net.URL;
import javax.xml.bind.*;
 
public class GoogleDemo {
 
    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(WeatherReport.class);
 
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        URL url = new URL("http://www.google.com/ig/api?weather=Ottawa");
        WeatherReport weatherReport = (WeatherReport) unmarshaller.unmarshal(url);
 
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(weatherReport, System.out);
    }
 
}