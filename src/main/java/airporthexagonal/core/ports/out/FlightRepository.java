package airporthexagonal.core.ports.out;

import java.util.List;

import airporthexagonal.domain.Flight;
import airporthexagonal.domain.FlightSearchCriteria;

public interface FlightRepository extends AbstractRepository<Flight>  {
  List<Flight> getByCriteria(FlightSearchCriteria criteria);
}
