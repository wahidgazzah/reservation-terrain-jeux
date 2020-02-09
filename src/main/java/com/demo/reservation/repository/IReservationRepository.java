package com.demo.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.reservation.entity.ReservationEntity;

@Repository
public interface IReservationRepository extends JpaRepository<ReservationEntity, Long>{
	
}
