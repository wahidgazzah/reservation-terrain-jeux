package com.demo.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.reservation.entity.JoueurEntity;

@Repository
public interface IJoueurRepository  extends JpaRepository<JoueurEntity, Long>{

}