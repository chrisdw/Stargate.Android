package uk.org.downesward.stargate;

import java.io.IOException;
import java.io.LineNumberReader;

import uk.org.downesward.utiliites.StringUtilities;

public class CivilRights {

	public String civilrights;
	public String subjagation;
	public String genocide;
	
	public CivilRights(LineNumberReader reader) throws IOException {
		// First we get the [CIVIL] tag
		reader.readLine();
		this.civilrights = StringUtilities.getPropertyValue(reader);
		this.subjagation = StringUtilities.getPropertyValue(reader);
		this.genocide = StringUtilities.getPropertyValue(reader);
	}
}
