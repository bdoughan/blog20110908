package blog.weather;
 
import java.util.*;
import javax.xml.bind.*;
import javax.xml.stream.*;
import javax.xml.transform.stream.StreamSource;
import org.eclipse.persistence.jaxb.JAXBContextFactory;
 
public class YahooDemo {
 
    public static void main(String[] args) throws Exception {
        Map<String, Object> properties = new HashMap<String, Object>(1);
        properties.put(JAXBContextFactory.ECLIPSELINK_OXM_XML_KEY, "blog/weather/yahoo-binding.xml");
        JAXBContext jc = JAXBContext.newInstance(new Class[] {WeatherReport.class}, properties);
 
        XMLInputFactory xif = XMLInputFactory.newFactory();
        StreamSource xml = new StreamSource("http://weather.yahooapis.com/forecastrss?w=3369");
        XMLStreamReader xsr = xif.createXMLStreamReader(xml);
        xsr = xif.createFilteredReader(xsr, new CDATAFilter());
 
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        WeatherReport weatherReport = (WeatherReport) unmarshaller.unmarshal(xsr);
 
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(weatherReport, System.out);
    }
 
    private static class CDATAFilter implements StreamFilter {
 
        public boolean accept(XMLStreamReader xsr) {
            return XMLStreamReader.CDATA != xsr.getEventType();
        }
 
    }
 
}