package uk.org.downesward.stargate;

import java.io.IOException;
import java.io.LineNumberReader;

import uk.org.downesward.utiliites.StringUtilities;

public class GeosphereBasic {
	public String geosphere;
	public String special;

	public GeosphereBasic(LineNumberReader reader) throws IOException {
		// First we get the [GEOB] tag
		reader.readLine();
		this.geosphere = StringUtilities.getPropertyValue(reader);
		this.special = StringUtilities.getPropertyValue(reader);
	}
}
