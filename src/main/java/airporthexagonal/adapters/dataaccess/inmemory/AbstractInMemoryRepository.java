package airporthexagonal.adapters.dataaccess.inmemory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import airporthexagonal.core.ports.out.AbstractRepository;
import airporthexagonal.domain.Entity;

public abstract class AbstractInMemoryRepository<T extends Entity> implements AbstractRepository<T> {
	protected final List<T> entities = new ArrayList<>();
	
	public T save(T entity) {
		this.entities.add(entity);
		return entity;
	}
	
	public void delete(T entity) {
		this.entities.remove(entity);
	}
	
	public T get(UUID id) {
		return entities.stream().filter(e -> id.equals(e.getId())).findFirst().orElse(null);
	}
	
	public List<T> getAll() {
		return entities;
	}
}
