package airporthexagonal.adapters.dataaccess.inmemory;

import airporthexagonal.core.ports.out.LaneRepository;
import airporthexagonal.domain.Lane;

public class LaneInMemoryRepository extends AbstractInMemoryRepository<Lane> implements LaneRepository {
	public Lane getByBK(String bk) {
		return super.entities.stream().filter(lane -> lane.getBK().equals(bk)).findFirst().orElse(null);
	}
}
