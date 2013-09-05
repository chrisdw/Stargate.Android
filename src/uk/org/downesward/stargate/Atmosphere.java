package uk.org.downesward.stargate;

import java.io.IOException;
import java.io.LineNumberReader;

import uk.org.downesward.utiliites.StringUtilities;

public class Atmosphere {
	public String atmosphere;
	public String cr;
	public String pressure;
	public String pen;
	public String increment;
	public String save;
	public String damage;
	public String time;
	
	public Atmosphere(LineNumberReader reader) throws IOException {
		// First we get the [ATMO] tag
		reader.readLine();
		this.atmosphere = StringUtilities.getPropertyValue(reader);
		this.cr = StringUtilities.getPropertyValue(reader);	
		this.pressure = StringUtilities.getPropertyValue(reader);	
		this.pen = StringUtilities.getPropertyValue(reader);
		this.increment = StringUtilities.getPropertyValue(reader);	
		this.save = StringUtilities.getPropertyValue(reader);
		this.damage = StringUtilities.getPropertyValue(reader);
		this.time = StringUtilities.getPropertyValue(reader);
	}
}
