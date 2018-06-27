package com.leszeknowinski.BarCodeStorageApp.repositories;

import com.leszeknowinski.BarCodeStorageApp.models.BarCodeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BarCodeEntityRepository extends CrudRepository<BarCodeEntity, Integer> {

    List<BarCodeEntity>findAllByOrderByIdDesc();
    List<BarCodeEntity>findByBarCodeLike(String s);
    List<BarCodeEntity>findByProductCompanyStartingWithAndIdIsGreaterThan(String s, int i);
    List<BarCodeEntity>findByBarCodeContainsOrBarCodeContainsAndWeightIsGreaterThanEqual(int s, int f, int c);
    List<BarCodeEntity>findByWeightIsBetween(int a, int b);
    List<BarCodeEntity>findAllByProductCompanyContains(String text);
    List<BarCodeEntity>findAllByProductNameContains(String text);
}
