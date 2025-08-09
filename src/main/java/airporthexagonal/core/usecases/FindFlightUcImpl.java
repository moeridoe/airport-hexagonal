package airporthexagonal.core.usecases;

import java.util.List;

import airporthexagonal.core.ports.in.FindFlightUc;
import airporthexagonal.core.ports.out.FlightRepository;
import airporthexagonal.domain.Flight;
import airporthexagonal.domain.FlightSearchCriteria;
import lombok.Data;

@Data
public class FindFlightUcImpl implements FindFlightUc {
	private final FlightRepository flightRepo;
	
	@Override
	public List<Flight> findFlightsByCriteria(FlightSearchCriteria searchCriteria) {
		return flightRepo.getByCriteria(searchCriteria);
	}
}
