package com.example.autokolcsonzo.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,String> {

    @Modifying
    @Query("UPDATE Car  SET  dailyPrice = ?2, disabled=?3 WHERE licensePlate  LIKE ?1 ")
    @Transactional
    void modifyCar(String licensePlate, int dailyPrice, boolean disabled);

    @Modifying
    @Query("UPDATE Car SET dailyPrice = ?2, disabled=?3, picture=?4 WHERE licensePlate LIKE ?1")
    @Transactional
    void modifyCarWithPicture(String licensePlate, int dailyPrice, boolean disabled, String picture);
}
