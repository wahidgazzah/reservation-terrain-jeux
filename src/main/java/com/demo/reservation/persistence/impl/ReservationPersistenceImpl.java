package com.demo.reservation.persistence.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.reservation.dto.JoueurDTO;
import com.demo.reservation.dto.ReservationDTO;
import com.demo.reservation.dto.ReservationRequestDTO;
import com.demo.reservation.entity.JoueurEntity;
import com.demo.reservation.entity.ReservationEntity;
import com.demo.reservation.persistence.IReservationPersistence;
import com.demo.reservation.repository.IJoueurRepository;
import com.demo.reservation.repository.IReservationRepository;
import com.demo.reservation.utilities.ReservationUtility;

/**
 * Implementation of {@link IReservationPersistence}
 * @author wahid
 *
 */
@Component
public class ReservationPersistenceImpl implements IReservationPersistence{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private IReservationRepository reservationRepository;
	
	@Autowired
	private IJoueurRepository joueurRepository;

	private static final Logger logger = LoggerFactory.getLogger(ReservationPersistenceImpl.class);

	/**
	 * Creer une reservation
	 */
	@Override
	public Long create(ReservationDTO dto) {

		ReservationEntity reservationEntity = reservationRepository.save(ReservationUtility.toEntity(dto));
		
		for(JoueurDTO joueurDTO : dto.getJoueursList()) {
			JoueurEntity joueurEntity = joueurRepository.getOne(joueurDTO.getId());
			joueurEntity.getReservationsList().add(reservationEntity);
			reservationEntity.getJoueursList().add(joueurEntity);
			joueurRepository.save(joueurEntity);
		}
		
		return reservationEntity.getId(); 
	}

	/**
	 * Recuperer tous les reservations
	 */
	@Override
	public List<ReservationDTO> getAll() {
		
		List<ReservationEntity> list = reservationRepository.findAll();
		
		return ReservationUtility.toDTO(list); 
	}
	
	/** Vérifier la disponiblitité d'une reservation d'un terrain sur un axe de temps,
	 * Le terain doit etre disponible sur la totalité de temps de reservation ( dateDebut, dateFin )
	 * Quatre cas pour avoir une intersection de temps avec une autre reservation (R0):
	 * cas_1: R0 CONTIENT nouvelleReservation.dateFin
	 * cas_2: R0 CONTIENT nouvelleReservation
	 * cas_3: R0 CONTIENT nouvelleReservation.dateDebut, ou de meme creneau
	 * cas_4: nouvelleReservation CONTIENT R0
	 * checkDisponibilite
	 */
	@Override
	public List<ReservationEntity> checkDisponibilite(ReservationRequestDTO request){
		
		List <ReservationEntity> result = new ArrayList<>();
		
		CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<ReservationEntity> criteriaQuery = criteriaBuilder.createQuery(ReservationEntity.class);
		List<Predicate> whereClause = new ArrayList<Predicate>();
		Root<ReservationEntity> root = criteriaQuery.from(ReservationEntity.class);
		
		whereClause.add(criteriaBuilder.equal(root.get("terrainType"), request.getTerrainType()));
		
    	Expression<Date> dateDeputPath = root.get("dateDebut");
    	Expression<Date> dateFinPath = root.get("dateFin");
    	
    	Predicate predicate_11 = criteriaBuilder.lessThan(dateDeputPath, request.getDateFin());
    	Predicate predicate_12 = criteriaBuilder.greaterThan(dateFinPath, request.getDateFin());
    	Predicate cas_1 = criteriaBuilder.and(predicate_11, predicate_12);

    	Predicate predicate_21 = criteriaBuilder.greaterThan(dateDeputPath, request.getDateDebut());
    	Predicate predicate_22 = criteriaBuilder.lessThan(dateFinPath, request.getDateDebut());
    	Predicate cas_2 = criteriaBuilder.and(predicate_21, predicate_22);
    	
    	Predicate predicate_31 = criteriaBuilder.greaterThanOrEqualTo(dateDeputPath, request.getDateDebut());
    	Predicate predicate_32 = criteriaBuilder.lessThanOrEqualTo(dateFinPath, request.getDateFin());
    	Predicate cas_3 = criteriaBuilder.and(predicate_31, predicate_32);
    	
    	Predicate predicate_41 = criteriaBuilder.lessThan(dateDeputPath, request.getDateDebut());
    	Predicate predicate_42 = criteriaBuilder.greaterThan(dateFinPath, request.getDateDebut());
    	Predicate cas_4 = criteriaBuilder.and(predicate_41, predicate_42);
    	
    	Predicate predicate_51 = criteriaBuilder.equal(dateDeputPath, request.getDateDebut());
    	Predicate predicate_52 = criteriaBuilder.equal(dateFinPath, request.getDateFin());
    	Predicate cas_5 = criteriaBuilder.and(predicate_41, predicate_42);
    	
    	Predicate predicate = criteriaBuilder.or(cas_1, cas_2, cas_3, cas_4, cas_5);
    	whereClause.add(criteriaBuilder.and(predicate));
    	
	    criteriaQuery.select(root).where(whereClause.toArray(new Predicate[] {}));
	    result = this.entityManager.createQuery(criteriaQuery).getResultList();
	    
	    return result;
	}
	
}
