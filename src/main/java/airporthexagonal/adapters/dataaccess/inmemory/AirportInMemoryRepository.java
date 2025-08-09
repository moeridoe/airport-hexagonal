package airporthexagonal.adapters.dataaccess.inmemory;

import java.util.List;

import airporthexagonal.core.ports.out.AirportRepository;
import airporthexagonal.domain.Airport;
import airporthexagonal.domain.AirportSearchCriteria;

public class AirportInMemoryRepository extends AbstractInMemoryRepository<Airport> implements AirportRepository {
	public Airport getByCode(String code) {
		return super.entities.stream().filter(airport -> airport.getCode().equals(code)).findFirst().orElse(null);
	}
	
	public List<Airport> getByCriteria(AirportSearchCriteria criteria) {
		return super.entities.stream().filter(airport -> {
			return (criteria.getCode() == null || airport.getCode().equals(criteria.getCode()))
				&& (criteria.getName() == null || airport.getName().equals(criteria.getName()));
		}).toList();
	}
	
	public List<Airport> getByCodeOrName(String input) {
		return super.entities.stream().filter(airport -> {
			return airport.getCode().toUpperCase().startsWith(input.toUpperCase())
				|| airport.getName().toUpperCase().startsWith(input.toUpperCase());
		}).toList();
	}
}
