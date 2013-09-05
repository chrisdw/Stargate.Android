package uk.org.downesward.stargate;

import java.io.IOException;
import java.io.LineNumberReader;

import uk.org.downesward.utiliites.StringUtilities;

public class Hydrosphere {
	public String hydrosphere;
	public String rain;
	public String none;
	public String flood;
	public String storm;
	public String wind;
	
	public Hydrosphere(LineNumberReader reader) throws IOException {
		// First we get the [HYDRO] tag
		reader.readLine();
		this.hydrosphere = StringUtilities.getPropertyValue(reader);
		this.rain = StringUtilities.getPropertyValue(reader);
		this.none = StringUtilities.getPropertyValue(reader);
		this.flood = StringUtilities.getPropertyValue(reader);
		this.storm = StringUtilities.getPropertyValue(reader);
		this.wind = StringUtilities.getPropertyValue(reader);	
	}
}
