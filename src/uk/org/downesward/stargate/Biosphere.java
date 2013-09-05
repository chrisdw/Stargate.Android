package uk.org.downesward.stargate;

import java.io.IOException;
import java.io.LineNumberReader;

public class Biosphere {
	public String biosphere;
	public String move;
	public String temperature;
	public String rain;
	public String vegetation;
	
	public Biosphere(LineNumberReader reader) throws IOException {
		// First we get the [BIO] tag
		reader.readLine();
		this.biosphere = reader.readLine().split("=")[1];
		this.move = reader.readLine().split("=")[1];
		this.temperature = reader.readLine().split("=")[1];
		this.rain = reader.readLine().split("=")[1];
		this.vegetation = reader.readLine().split("=")[1];
	}
}
