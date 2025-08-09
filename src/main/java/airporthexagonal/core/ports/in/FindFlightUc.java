package airporthexagonal.core.ports.in;

import java.util.List;

import airporthexagonal.domain.Flight;
import airporthexagonal.domain.FlightSearchCriteria;

public interface FindFlightUc {
	public List<Flight> findFlightsByCriteria(FlightSearchCriteria searchCriteria);
}
