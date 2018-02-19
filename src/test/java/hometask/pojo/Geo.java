package hometask.pojo;




import java.util.HashMap;
import java.util.Map;

public class Geo {

    private String lat;
    private String lng;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	@Override
	public String toString() {
		return "Geo [lat=" + lat + ", lng=" + lng + ", additionalProperties=" + additionalProperties + "]";
	}

}
