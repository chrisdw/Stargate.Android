package uk.org.downesward.stargate;

import java.io.IOException;
import java.io.LineNumberReader;

import uk.org.downesward.utiliites.StringUtilities;

public class Biosphere {
	public String biosphere;
	public String move;
	public String temperature;
	public String rain;
	public String vegetation;
	
	public Biosphere(LineNumberReader reader) throws IOException {
		// First we get the [BIO] tag
		reader.readLine();
		this.biosphere = StringUtilities.getPropertyValue(reader);
		this.move = StringUtilities.getPropertyValue(reader);
		this.temperature = StringUtilities.getPropertyValue(reader);
		this.rain = StringUtilities.getPropertyValue(reader);
		this.vegetation = StringUtilities.getPropertyValue(reader);
	}
}
