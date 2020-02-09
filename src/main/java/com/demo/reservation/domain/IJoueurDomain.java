package com.demo.reservation.domain;

import com.demo.reservation.dto.JoueurDTO;

/**
 * Joueur Domain
 * @author wahid
 *
 */
public interface IJoueurDomain {

	Long inscription(JoueurDTO dto);

}
