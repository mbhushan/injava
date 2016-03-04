package otp;

import java.util.HashMap;
import java.util.Map;

public class OTPProviderBase implements OTPProvider {
	
	protected Map<String, String> properties = new HashMap<String, String>();

	@Override
	public String getName() {
		return null;
	}

	@Override
	public String generate(String key, String base,  int digits) {
		return null;
	}

	@Override
	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

	@Override
	public Map<String, String> getProperties() {
		return properties;
	}

}
