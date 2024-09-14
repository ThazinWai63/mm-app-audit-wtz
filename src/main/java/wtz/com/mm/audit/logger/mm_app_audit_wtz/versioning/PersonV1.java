package wtz.com.mm.audit.logger.mm_app_audit_wtz.versioning;

public class PersonV1 {
	
	private String name;

	public PersonV1(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}

}
