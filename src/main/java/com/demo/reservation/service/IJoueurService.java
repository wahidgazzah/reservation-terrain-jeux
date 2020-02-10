package com.demo.reservation.service;

import org.springframework.transaction.annotation.Transactional;

import com.demo.reservation.dto.JoueurDTO;

/**
 * Joueur Service
 * @author wahid
 *
 */

public interface IJoueurService {

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	Long inscription(JoueurDTO dto);
}
