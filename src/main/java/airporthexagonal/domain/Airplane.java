package airporthexagonal.domain;

import java.util.UUID;

import lombok.Getter;

@Getter
public class Airplane extends Entity {
	private final String planeModel;
	private final String planeNumber;
	
	public Airplane(String planeModel, String planeNumber) {
		super(UUID.randomUUID());
		this.planeModel = planeModel;
		this.planeNumber = planeNumber;
	}
}
