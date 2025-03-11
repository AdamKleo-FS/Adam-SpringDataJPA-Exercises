package com.futurespace.springdata.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

/*
Boilerplate service for all the other entity services to extend.
Each individual service can then add its own functionality, unique to it
 */
public abstract class BaseService<T, ID> {

    protected final JpaRepository<T, ID> repository;

    protected BaseService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    public ResponseEntity<T> save(T entity) {
        T savedEntity = repository.save(entity);
        return ResponseEntity.status(201).body(savedEntity);
    }

    public ResponseEntity<List<T>> saveAll(List<T> entities) {
        List<T> savedEntities = repository.saveAll(entities);
        return ResponseEntity.status(201).body(savedEntities);
    }

    public ResponseEntity<T> getById(ID id) {
        Optional<T> entity = repository.findById(id);
        return entity.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public List<T> getAll() {
        return repository.findAll();
    }

    public ResponseEntity<T> update(ID id, T updatedEntity) {
        return repository.findById(id)
                .map(existingEntity -> {
                    copyNonNullProperties(updatedEntity, existingEntity); // Copy only non-null values
                    return ResponseEntity.ok(repository.save(existingEntity));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    public ResponseEntity<Void> delete(ID id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    private void copyNonNullProperties(T source, T target) {
        java.beans.BeanInfo beanInfo;
        try {
            beanInfo = java.beans.Introspector.getBeanInfo(source.getClass());
            for (java.beans.PropertyDescriptor property : beanInfo.getPropertyDescriptors()) {
                java.lang.reflect.Method getter = property.getReadMethod();
                java.lang.reflect.Method setter = property.getWriteMethod();
                if (getter != null && setter != null) {
                    Object value = getter.invoke(source);
                    if (value != null) {
                        setter.invoke(target, value);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error copying properties", e);
        }
    }

}
