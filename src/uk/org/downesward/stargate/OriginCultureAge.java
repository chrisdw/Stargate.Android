package uk.org.downesward.stargate;

import java.io.IOException;
import java.io.LineNumberReader;

import uk.org.downesward.utiliites.StringUtilities;

public class OriginCultureAge {
	public String origincultureage;
	
	public OriginCultureAge(LineNumberReader reader) throws IOException {
		// First we get the [ORIA] tag
		reader.readLine();
		this.origincultureage = StringUtilities.getPropertyValue(reader);
	}
}
