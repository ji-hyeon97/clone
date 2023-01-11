package eatda.clone.repository;

import eatda.clone.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {

    @Override
    Optional<Store> findById(Long id);

    @Query("select s from Store s join fetch s.menus m where m.store.id = :id")
    Optional<Store> findByIdWithMenus(@Param("id") Long id);
}
