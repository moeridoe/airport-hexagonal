package airporthexagonal.core.ports.out;

import java.util.List;
import java.util.UUID;

import airporthexagonal.domain.Entity;

public interface AbstractRepository<T extends Entity> {
  T save(T entity);
  
  void delete(T entity);
  
  T get(UUID id);
  
  List<T> getAll();
}
