package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Item;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ItemRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Item item) {

        if (item.getId() == null) {
            entityManager.persist(item);
        } else {
            entityManager.merge(item);
        }
    }

    public Item findOne(Long id) {
        return entityManager.find(Item.class, id);
    }

    public List<Item> findAll() {
        // 영속 상태의 엔티티는 변경 감지 기능이 동작해서 트랜잭션을 커밋할 때 자동으로 수정된다.
        // 아래는 준영속 상태의 엔티티를 수정할 때 사용한다.
        return entityManager.createQuery("select i from Item i", Item.class).getResultList();
    }
}
