package uk.org.downesward.stargate;

import java.io.IOException;
import java.io.LineNumberReader;

import uk.org.downesward.utiliites.StringUtilities;

public class GeosphereTectonic {
	public String geosphere;
	public String quakesnone;
	public String quakesminor;
	public String quakesmoderate;
	public String quakesmajor;
	public String volcanoesnone;
	public String volcanoessmall;
	public String volcanoesmedium;
	public String volcanoeslarge;
	
	public GeosphereTectonic(LineNumberReader reader) throws IOException {
		// First we get the [GEOT] tag
		reader.readLine();
		this.geosphere = StringUtilities.getPropertyValue(reader);
		this.quakesnone = StringUtilities.getPropertyValue(reader);
		this.quakesminor = StringUtilities.getPropertyValue(reader);
		this.quakesmoderate = StringUtilities.getPropertyValue(reader);
		this.quakesmajor = StringUtilities.getPropertyValue(reader);
		this.volcanoesnone = StringUtilities.getPropertyValue(reader);
		this.volcanoessmall = StringUtilities.getPropertyValue(reader);
		this.volcanoesmedium = StringUtilities.getPropertyValue(reader);
		this.volcanoeslarge = StringUtilities.getPropertyValue(reader);

	}	
}
