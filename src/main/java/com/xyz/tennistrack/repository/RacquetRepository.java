package com.xyz.tennistrack.repository;

import com.xyz.tennistrack.model.Entity.Racquets;
import com.xyz.tennistrack.model.enums.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RacquetRepository extends PagingAndSortingRepository<Racquets, String> {

    List<Racquets> findRacquetsByBrand(Brand brand);

    @Query("SELECT COUNT(*) FROM Racquets")
    int getAllRacquetsCount();
}
