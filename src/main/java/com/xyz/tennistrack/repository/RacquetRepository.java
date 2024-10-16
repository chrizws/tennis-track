package com.xyz.tennistrack.repository;

import com.xyz.tennistrack.model.tennisProducts.Racquets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RacquetRepository extends JpaRepository<Racquets, String> {
}
