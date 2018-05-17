package lanSimulation.internals;

import lanSimulation.Network;

public class WorkStation extends Node{

	public WorkStation(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void printXMLString(StringBuffer buf) {
		buf.append("<workstation>");
		buf.append(name_);
		buf.append("</workstation>");
	}
	
	@Override
	protected void printOnString(StringBuffer buf) {
		buf.append("Workstation ");
		buf.append(name_);
		buf.append(" [Workstation]");
	}
	
	@Override
	public boolean isWorkStation() {
		return true;
	}

}
