package uk.org.downesward.stargate;

import java.io.IOException;
import java.io.LineNumberReader;

public class GeosphereBasic {
	public String geosphere;
	public String special;

	public GeosphereBasic(LineNumberReader reader) throws IOException {
		// First we get the [GEOB] tag
		reader.readLine();
		this.geosphere = reader.readLine().split("=")[1];
		this.special = reader.readLine().split("=")[1];
	}
}
