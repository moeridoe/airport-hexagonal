package airporthexagonal.core.ports.out;

import java.util.List;

import airporthexagonal.domain.Airport;
import airporthexagonal.domain.AirportSearchCriteria;

public interface AirportRepository extends AbstractRepository<Airport> {
  Airport getByCode(String code);
  
  List<Airport> getByCriteria(AirportSearchCriteria criteria);
  
  List<Airport> getByCodeOrName(String input);
}
