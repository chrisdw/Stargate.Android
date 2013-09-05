package uk.org.downesward.stargate;

import java.io.IOException;
import java.io.LineNumberReader;

import uk.org.downesward.utiliites.StringUtilities;

public class Anthrosphere {
	public String anthrosphere;
	public String advances;
	public String weapons;
	public String vehicles;
	public String picks;
	public String rp;
	
	public Anthrosphere(LineNumberReader reader) throws IOException {
		// First we get the [ANTHRO] tag
		reader.readLine();
		this.anthrosphere = StringUtilities.getPropertyValue(reader);
		this.advances = StringUtilities.getPropertyValue(reader);
		this.weapons = StringUtilities.getPropertyValue(reader);
		this.vehicles = StringUtilities.getPropertyValue(reader);
		this.picks = StringUtilities.getPropertyValue(reader);
		this.rp = StringUtilities.getPropertyValue(reader);
	}
}
