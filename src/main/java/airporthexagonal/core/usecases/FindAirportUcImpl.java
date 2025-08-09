package airporthexagonal.core.usecases;

import java.util.List;

import airporthexagonal.core.ports.in.FindAirportUc;
import airporthexagonal.core.ports.out.AirportRepository;
import airporthexagonal.domain.Airport;
import airporthexagonal.domain.AirportSearchCriteria;
import lombok.Data;

@Data
public class FindAirportUcImpl implements FindAirportUc {
	private final AirportRepository airportRepo;

	@Override
	public List<Airport> findAirportsByCriteria(AirportSearchCriteria searchCriteria) {
		return this.airportRepo.getByCriteria(searchCriteria);
	}

	@Override
	public List<Airport> findAirportsByCodeOrName(String codeOrName) {
		return this.airportRepo.getByCodeOrName(codeOrName);
	}
}
