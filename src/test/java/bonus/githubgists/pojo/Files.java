package bonus.githubgists.pojo;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"ring.erl"
})
public class Files {

@JsonProperty("file")
private File file;

@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();


@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}
@JsonProperty("file")
public File getFile() {
	return file;
}
@JsonProperty("file")
public void setFile(File file) {
	this.file = file;
}

}
