package airporthexagonal.adapters.dataaccess.inmemory;

import java.util.List;

import airporthexagonal.core.ports.out.FlightRepository;
import airporthexagonal.domain.Flight;
import airporthexagonal.domain.FlightSearchCriteria;

public class FlightInMemoryRepository extends AbstractInMemoryRepository<Flight> implements FlightRepository {
	public List<Flight> getByCriteria(FlightSearchCriteria criteria) {
		return super.entities.stream().filter(flight -> {
			return (criteria.getFromAirport() == null || flight.getLane().getOrigin().equals(criteria.getFromAirport()))
				&& (criteria.getToAirport() == null || flight.getLane().getDestination().equals(criteria.getToAirport()))
				&& (criteria.getEarliestDeparture() == null || !flight.getDeparture().isBefore(criteria.getEarliestDeparture()));
		}).toList();
	}
}
