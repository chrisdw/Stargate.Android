package uk.org.downesward.stargate;

import java.io.IOException;
import java.io.LineNumberReader;

import uk.org.downesward.utiliites.StringUtilities;

public class Xenophobia {

	public String xenophobia;
	public String disposition;
	public String modifier;
	
	public Xenophobia(LineNumberReader reader) throws IOException {
		// First we get the [XENO] tag
		reader.readLine();
		this.xenophobia = StringUtilities.getPropertyValue(reader);
		this.disposition = StringUtilities.getPropertyValue(reader);
		this.modifier = StringUtilities.getPropertyValue(reader);
	}
}
