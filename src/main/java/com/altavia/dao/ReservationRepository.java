package com.altavia.dao;

import org.springframework.data.repository.CrudRepository;

import com.altavia.model.Reservation;
import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation,Long>{

	List<Reservation> findByDate(LocalDate date);
}
