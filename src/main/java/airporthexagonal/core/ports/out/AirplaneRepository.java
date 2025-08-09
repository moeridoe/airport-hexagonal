package airporthexagonal.core.ports.out;

import airporthexagonal.domain.Airplane;

public interface AirplaneRepository extends AbstractRepository<Airplane> {
  Airplane getByPlaneNumber(String planeNumber);
}
