package airporthexagonal.core.ports.out;

import airporthexagonal.domain.Lane;

public interface LaneRepository extends AbstractRepository<Lane>  {
  Lane getByBK(String bk);
}
