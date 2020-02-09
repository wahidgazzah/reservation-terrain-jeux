package com.demo.reservation.persistence;

import com.demo.reservation.dto.JoueurDTO;

/**
 * Joueur Persistence Interface
 * @author wahid
 *
 */
public interface IJoueurPersistence {

	Long inscription(JoueurDTO dto);
	
}
