package lanSimulation.internals;

import java.io.IOException;
import java.io.Writer;

import lanSimulation.Network;

public class Printer extends Node{

	public Printer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public boolean printDocument(Network network, Packet packet, Writer report, String author, String title) {
		int startPos;
		int endPos;
		try {
			if (packet.message_.startsWith("!PS")) {
				startPos = packet.message_.indexOf("author:");
				if (startPos >= 0) {
					endPos = packet.message_.indexOf(".", startPos + 7);
					if (endPos < 0) {
						endPos = packet.message_.length();
					}
					author = packet.message_.substring(startPos + 7, endPos);
				}
				startPos = packet.message_.indexOf("title:");
				if (startPos >= 0) {
					endPos = packet.message_.indexOf(".", startPos + 6);
					if (endPos < 0) {
						endPos = packet.message_.length();
					}
					title = packet.message_.substring(startPos + 6, endPos);
				}
				String end = ">>> Postscript job delivered.\n\n";
				network.accountingString(report, author, title, end);
			} else {
				title = "ASCII DOCUMENT";
				if (packet.message_.length() >= 16) {
					author = packet.message_.substring(8, 16);
				}
				String end = ">>> ASCII Print job delivered.\n\n";
				network.accountingString(report, author, title, end);
			}
		} catch (IOException exc) {
			// just ignore
		}
		return true;
	}
	
	@Override
	protected void printXMLString(StringBuffer buf) {
		buf.append("<printer>");
		buf.append(name_);
		buf.append("</printer>");
	}
	
	@Override
	protected void printOnString(StringBuffer buf) {
		buf.append("Printer ");
		buf.append(name_);
		buf.append(" [Printer]");
	}
	
	@Override
	public boolean isPrinter() {
		return true;
	}


}
