package airporthexagonal.adapters.dataaccess.inmemory;

import airporthexagonal.core.ports.out.AirplaneRepository;
import airporthexagonal.domain.Airplane;

public class AirplaneInMemoryRepository extends AbstractInMemoryRepository<Airplane> implements AirplaneRepository {
	public Airplane getByPlaneNumber(String planeNumber) {
		return super.entities.stream().filter(airplane -> airplane.getPlaneNumber().equals(planeNumber)).findFirst().orElse(null);
	}
}
