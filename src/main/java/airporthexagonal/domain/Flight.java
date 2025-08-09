package airporthexagonal.domain;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Getter;

@Getter
public class Flight extends Entity {
	private final Lane lane;
	private final LocalDate departure;
	private final LocalDate arrival;
	private final Double price;

	public Flight(Lane lane, LocalDate departure, LocalDate arrival, Double price) {
		super(UUID.randomUUID());
		this.lane = lane;
		this.departure = departure;
		this.arrival = arrival;
		this.price = price;
	}
}
