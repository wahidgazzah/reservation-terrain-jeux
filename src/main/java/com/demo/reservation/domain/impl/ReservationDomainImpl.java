package com.demo.reservation.domain.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.reservation.domain.IReservationDomain;
import com.demo.reservation.dto.JoueurDTO;
import com.demo.reservation.dto.ReservationDTO;
import com.demo.reservation.dto.ReservationRequestDTO;
import com.demo.reservation.dto.ReservationResponseDTO;
import com.demo.reservation.dto.ReservationTerrainState;
import com.demo.reservation.entity.ReservationEntity;
import com.demo.reservation.persistence.IReservationPersistence;
import com.demo.reservation.service.IYahooWeatherService;

/**
 * Implementation of {@link IReservationDomain}
 * @author wahid
 *
 */
@Component
public class ReservationDomainImpl implements IReservationDomain{
	
	private final static double PRIX_HEURE = 8D;
	private final static double REDUCTION = 5D;

	@Autowired
	private IReservationPersistence reservationPersistence;
	
	@Autowired
	private IYahooWeatherService yahooWeatherService;

	private static final Logger logger = LoggerFactory.getLogger(ReservationDomainImpl.class);
	
	/**
	 * recuperer la liste des reservations
	 */
	@Override
	public List<ReservationDTO> getAll() {
		
		return reservationPersistence.getAll();
	}

	/**
	 * reservation
	 */
	@Override
	public ReservationResponseDTO reservation(ReservationRequestDTO request) {
		
		ReservationResponseDTO response = new ReservationResponseDTO();
		
		boolean disponible = checkDisponibilite(request);
		
		if(request.getIdsJoueurs() == null) {
			response.setReservationTerrainState(ReservationTerrainState.NON_DISPONIBLE_JOUEURS_OBLIGAOIRE);
		}else if(request.getIdsJoueurs().size() < 2) {
			response.setReservationTerrainState(ReservationTerrainState.NON_DISPONIBLE_NBR_JOUEURS_INF_2);
		}else if(request.getIdsJoueurs().size() > 8) {
			response.setReservationTerrainState(ReservationTerrainState.NON_DISPONIBLE_NBR_JOUEURS_SUP_8);
		}else if(request.getDateDebut().compareTo(request.getDateFin()) > 0) {
			response.setReservationTerrainState(ReservationTerrainState.NON_DISPONIBLE_DATE_RESERVATION_ERRONEES);
		}else if(disponible) {
			
			switch (request.getTerrainType()) {
			case SOL_NATUREL_EXTERIEUR:
			case HERBRE_EXTERIEUR:

				boolean previsionPluie = checkPrevisionPluie(request);
				
				if(!previsionPluie) {
					response = doReservation(request);
					response.setReservationTerrainState(ReservationTerrainState.DISPONIBLE);
				}else {
					response.setReservationTerrainState(ReservationTerrainState.NON_DISPONIBLE_PREVISION_PLUIE);
				}
				
				break;
			case BITUME_INTERIEUR:
				response = doReservation(request);
				response.setReservationTerrainState(ReservationTerrainState.DISPONIBLE);
				break;
			default:
				break;
			}
		}else {
			response.setReservationTerrainState(ReservationTerrainState.NON_DISPONIBLE_RESERVE);
		}

		return response;
	}
	
	/**
	 * doReservation
	 * @param request
	 * @return
	 */
	private ReservationResponseDTO doReservation(ReservationRequestDTO request) {
		
		ReservationResponseDTO response = new ReservationResponseDTO();

		long diff = request.getDateFin().getTime() - request.getDateDebut().getTime();
		
		int hours = (int) (diff / (60 * 60 * 1000));
		int reste_minutes = ((int) (hours * 60) - ((int) diff / (60 * 1000)));
		
		double prix;
		//Le prix d'une heure et de 8 euro, les suivantes sont a 5%
		if(hours > 0) {
			prix =  PRIX_HEURE + ( (double)((hours-1) * PRIX_HEURE) - ((double)((hours-1) * PRIX_HEURE * REDUCTION) / 100)) ;
			if(reste_minutes % 60 > 0) {
				if(hours == 1) 
					prix = prix + PRIX_HEURE;
				else 
					prix = prix + (double)((PRIX_HEURE * REDUCTION) / 100);
			}
				
		}else {
			// creneau minimum est d'une heure
			prix = PRIX_HEURE;
		}
		
		response.setPrix(prix);
		
		ReservationDTO reservation = new ReservationDTO();
		reservation.setDateReservation(new Date());
		reservation.setDateDebut(request.getDateDebut());
		reservation.setDateFin(request.getDateFin());
		reservation.setFacture(prix);
		reservation.setTerrainType(request.getTerrainType());
		for(Long id : request.getIdsJoueurs()) {
			JoueurDTO joueur = new JoueurDTO();
			joueur.setId(id);
			reservation.getJoueursList().add(joueur);
		}
		
		reservationPersistence.create(reservation);
		
		return response;
	}
	
	/**
	 * verifier la disponibilite
	 * @param request
	 * @return
	 */
	private boolean checkDisponibilite(ReservationRequestDTO request) {
		
		List<ReservationEntity> result = reservationPersistence.checkDisponibilite(request);
		
		if(result != null && result.size() == 0)
			return true;
		
		return false;
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	private boolean checkPrevisionPluie(ReservationRequestDTO request) {
		
		logger.info("Call yahoo weather service");
		
		return yahooWeatherService.checkPrevisionPluie(request);
	}


}
