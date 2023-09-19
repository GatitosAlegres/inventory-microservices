package com.example.productsservice.services.common;

import com.example.productsservice.entities.Identifiable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class ResourceService<M extends Identifiable<K>, K>  {

    protected abstract JpaRepository<M, K> getJpaRepository();

    public List<M> findAll() {
        return getJpaRepository().findAll();
    }

    public Optional<M> findById(K id) {
        return getJpaRepository().findById(id);

    }

    public M save(M model) {
        return getJpaRepository().save(model);
    }

    public M update(K id, M model) {
        var modelFromDB = getJpaRepository().findById(id);
        if (modelFromDB.isPresent()) {

            model.setId(id);
            model.setCreatedAt(modelFromDB.get().getCreatedAt());

            return getJpaRepository().save(model);
        }
        return null;
    }

    public Boolean deleteById(K id) {
        try {
            getJpaRepository().deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
