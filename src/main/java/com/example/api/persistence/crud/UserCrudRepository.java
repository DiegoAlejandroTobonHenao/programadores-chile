package com.example.api.persistence.crud;


import com.example.api.persistence.models.UserDAO;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserCrudRepository extends CrudRepository<UserDAO,Integer> {

    List<UserDAO> findByDocumentTypeIdOrderByAgeAsc(int documentTypeId);
    List<UserDAO> findByAgeGreaterThanOrderByAgeAsc(int age);
    List<UserDAO> findByAgeLessThanOrderByAgeAsc(int age);
    List<UserDAO> findByAgeGreaterThanEqualOrderByAgeAsc(int age);
    List<UserDAO> findByAgeLessThanEqualOrderByAgeAsc(int age);

}
