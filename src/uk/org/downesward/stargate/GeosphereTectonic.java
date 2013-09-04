package uk.org.downesward.stargate;

import java.io.IOException;
import java.io.LineNumberReader;

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
		this.geosphere = reader.readLine().split("=")[1];
		this.quakesnone = reader.readLine().split("=")[1];
		this.quakesminor = reader.readLine().split("=")[1];
		this.quakesmoderate = reader.readLine().split("=")[1];
		this.quakesmajor = reader.readLine().split("=")[1];
		this.volcanoesnone = reader.readLine().split("=")[1];
		this.volcanoessmall = reader.readLine().split("=")[1];
		this.volcanoesmedium = reader.readLine().split("=")[1];
		this.volcanoeslarge = reader.readLine().split("=")[1];

	}	
}
