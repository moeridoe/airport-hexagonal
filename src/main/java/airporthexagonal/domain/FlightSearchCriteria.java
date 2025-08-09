package airporthexagonal.domain;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FlightSearchCriteria {
	private LocalDate earliestDeparture;
	private Airport fromAirport;
	private Airport toAirport;
}
