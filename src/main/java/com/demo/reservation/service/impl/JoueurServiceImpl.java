package com.demo.reservation.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.reservation.domain.IJoueurDomain;
import com.demo.reservation.dto.JoueurDTO;
import com.demo.reservation.service.IJoueurService;

/**
 * Implementation of {@link IJoueurService}
 * @author wahid
 *
 */
@Service
public class JoueurServiceImpl implements IJoueurService{

	private static final Logger logger = LoggerFactory.getLogger(JoueurServiceImpl.class);
	
	@Autowired
	private IJoueurDomain joueurDomain;

	@Override
	public Long inscription(JoueurDTO dto) {
		
		logger.info("Delegating request to Domain layer.");
		
		return joueurDomain.inscription(dto);
	}
	
}
