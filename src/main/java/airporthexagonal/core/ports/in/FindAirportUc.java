package airporthexagonal.core.ports.in;

import java.util.List;

import airporthexagonal.domain.Airport;
import airporthexagonal.domain.AirportSearchCriteria;

public interface FindAirportUc {
	public List<Airport> findAirportsByCriteria(AirportSearchCriteria searchCriteria);

	public List<Airport> findAirportsByCodeOrName(String codeOrName);
}
