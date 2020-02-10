package com.demo.reservation.persistence.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.reservation.dto.JoueurDTO;
import com.demo.reservation.entity.JoueurEntity;
import com.demo.reservation.persistence.IJoueurPersistence;
import com.demo.reservation.repository.IJoueurRepository;
import com.demo.reservation.utilities.JoueurUtility;

/**
 * Implementation of {@link IJoueurPersistence}
 * @author wahid
 *
 */
@Component
public class JoueurPersistenceImpl implements IJoueurPersistence{

	@Autowired
	private IJoueurRepository joueurRepository;

	private static final Logger logger = LoggerFactory.getLogger(JoueurPersistenceImpl.class);

	/**
	 * inscription joueur
	 */
	@Override
	public Long inscription(JoueurDTO dto) {
		
		logger.info("player inscription");
		
		JoueurEntity entity = joueurRepository.save(JoueurUtility.toEntity(dto));
		
		return entity.getId(); 
	}
	
}
