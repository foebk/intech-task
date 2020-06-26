package intech.Repos;

import intech.Entities.PurchaseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
@Table(name = "purchase")
public interface PurchaseRepo extends CrudRepository<PurchaseEntity, Integer> {
}
