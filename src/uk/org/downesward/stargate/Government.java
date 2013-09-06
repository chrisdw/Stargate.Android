package uk.org.downesward.stargate;

import java.io.IOException;
import java.io.LineNumberReader;

import uk.org.downesward.utiliites.StringUtilities;

public class Government {
	public String government;
	public String ruler;
	
	public Government(LineNumberReader reader) throws IOException {
		// First we get the [GOV] tag
		reader.readLine();
		this.government = StringUtilities.getPropertyValue(reader);
		this.ruler = StringUtilities.getPropertyValue(reader);
	}
}
