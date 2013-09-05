package uk.org.downesward.stargate;

import java.io.IOException;
import java.io.LineNumberReader;

import uk.org.downesward.utiliites.StringUtilities;

public class Thermosphere {
	public String thermo;
	public String cr;
	public String orbit;
	public String temp;
	
	public Thermosphere(LineNumberReader reader) throws IOException {
		// First we get the [THERMO] tag
		reader.readLine();
		this.thermo = StringUtilities.getPropertyValue(reader);
		this.cr = StringUtilities.getPropertyValue(reader);
		this.orbit = StringUtilities.getPropertyValue(reader);
		this.temp = StringUtilities.getPropertyValue(reader);
	}
}
