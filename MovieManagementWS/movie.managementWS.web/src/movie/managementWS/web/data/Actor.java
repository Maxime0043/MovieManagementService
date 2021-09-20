package movie.managementWS.web.data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class allowing to create an actor.
 * 
 * @author Maxime PINNA and Micaël DUPUIS.
 *
 */
@XmlRootElement
public class Actor {
	
	private String name;
	private String role;
	
	public Actor() {};
	
	public Actor(String name, String role) {
		this.name = name;
		this.role = role;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
