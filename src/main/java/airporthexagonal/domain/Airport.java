package airporthexagonal.domain;

import java.util.UUID;

import lombok.Getter;

@Getter
public class Airport extends Entity {
	private final String code;
	private final String name;
	
	public Airport(String code, String name) {
		super(UUID.randomUUID());
		this.code = code;
		this.name = name;
	}
}
