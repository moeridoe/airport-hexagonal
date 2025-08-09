package airporthexagonal.domain;

import java.util.UUID;

import lombok.Getter;

@Getter
public class Lane extends Entity {
	private final Airplane airplane;
	private final Airport origin;
	private final Airport destination;
	
	public Lane(Airplane airplane, Airport origin, Airport destination) {
		super(UUID.randomUUID());
		this.airplane = airplane;
		this.origin = origin;
		this.destination = destination;
	}
	
	public String getBK() {
		return origin.getCode() + destination.getCode();
	}
}
