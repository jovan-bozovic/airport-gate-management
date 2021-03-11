package com.bozovic.airportgatemanagement.repositories;

import com.bozovic.airportgatemanagement.models.Gate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface GateRepository extends JpaRepository<Gate, Integer> {
    @Query(value =
            "SELECT * " +
            "FROM `gates` " +
            "WHERE FORMATDATETIME(current_timestamp(), 'HH:mm:ss')" +
                    " BETWEEN `available_from` AND" +
                    " `available_to` AND `in_use` = false;", nativeQuery = true)
    ArrayList<Gate> getAvailable();
}
