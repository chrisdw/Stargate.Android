package uk.org.downesward.stargate;

import java.io.IOException;
import java.io.LineNumberReader;

import uk.org.downesward.utiliites.StringUtilities;

public class OriginCultureRoots {
	public String origincultureroots;
	public String description;
	
	public OriginCultureRoots(LineNumberReader reader) throws IOException {
		// First we get the [ORIR] tag
		reader.readLine();
		this.origincultureroots = StringUtilities.getPropertyValue(reader);
		this.description = StringUtilities.getPropertyValue(reader);
	}
}
