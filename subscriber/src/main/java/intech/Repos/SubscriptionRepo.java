package intech.Repos;

import intech.Entities.SubcriptionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
@Table(name = "subscription")
public interface SubscriptionRepo extends CrudRepository<SubcriptionEntity, Integer> {
}
