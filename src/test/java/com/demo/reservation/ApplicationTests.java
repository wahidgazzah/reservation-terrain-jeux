package com.demo.reservation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.reservation.dto.JoueurDTO;
import com.demo.reservation.dto.ReservationRequestDTO;
import com.demo.reservation.dto.ReservationResponseDTO;
import com.demo.reservation.dto.ReservationTerrainState;
import com.demo.reservation.dto.TerrainType;
import com.demo.reservation.service.IJoueurService;
import com.demo.reservation.service.IReservationService;
import com.demo.reservation.service.IYahooWeatherService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
class ApplicationTests {

	@Autowired
	private IJoueurService joueurService;
	
	@Autowired
	private IReservationService reservationService;
	
	@Mock
	IYahooWeatherService yahooWeatherService;
	
	private static JoueurDTO joueur_1;
	private static JoueurDTO joueur_2;
	private static Long id_joueur_1;
	private static Long id_joueur_2;
	
	private static LocalDateTime dateDebut;
	private static LocalDateTime dateFin;
	
	@Before
	public void init() {
		
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void test_inscription_joueur() {
		
		create_users();
		
		assertNotNull(id_joueur_1);
		assertNotNull(id_joueur_2);
	}
	
	@Test
	public void test_reservation_NON_DISPONIBLE_RESERVE() {
		
		//create users
		create_users();
		
		// first  reservation, from 12h00 to 14h00
		ReservationRequestDTO first_request = first_request_reservation();
		reservationService.reservation(first_request);
		
		// second reservation, from 10h30 to 12h30
		dateDebut = LocalDateTime.of(2020, Month.APRIL, 10, 10, 30);
		dateFin = LocalDateTime.of(2020, Month.APRIL, 10, 12, 30);
		
		ReservationRequestDTO request = new ReservationRequestDTO();
		request.setIdsJoueurs(new ArrayList<Long>(Arrays.asList(id_joueur_1, id_joueur_2)));
		request.setDateDebut(Date.from(dateDebut.atZone(ZoneId.systemDefault()).toInstant()));
		request.setDateFin(Date.from(dateFin.atZone(ZoneId.systemDefault()).toInstant()));
		request.setTerrainType(TerrainType.SOL_NATUREL_EXTERIEUR);
		
		ReservationResponseDTO response = reservationService.reservation(request);
		
		assertEquals(response.getReservationTerrainState(), ReservationTerrainState.NON_DISPONIBLE_RESERVE);
	}
	
	@Test
	public void test_reservation_NON_DISPONIBLE_PREVISION_PLUIE() {
		
		//create users
		create_users();
		
		// second reservation, from 08h30 to 10h30
		dateDebut = LocalDateTime.of(2020, Month.APRIL, 10, 8, 30);
		dateFin = LocalDateTime.of(2020, Month.APRIL, 10, 10, 30);
		
		ReservationRequestDTO request = new ReservationRequestDTO();
		request.setIdsJoueurs(new ArrayList<Long>(Arrays.asList(id_joueur_1, id_joueur_2)));
		request.setDateDebut(Date.from(dateDebut.atZone(ZoneId.systemDefault()).toInstant()));
		request.setDateFin(Date.from(dateFin.atZone(ZoneId.systemDefault()).toInstant()));
		request.setTerrainType(TerrainType.SOL_NATUREL_EXTERIEUR);

		ReservationResponseDTO response = new ReservationResponseDTO();
		response.setReservationTerrainState(ReservationTerrainState.NON_DISPONIBLE_PREVISION_PLUIE);
		
		Mockito.when(yahooWeatherService.checkPrevisionPluie(any(ReservationRequestDTO.class))).thenReturn(true);
		
		assertEquals(response.getReservationTerrainState(), ReservationTerrainState.NON_DISPONIBLE_PREVISION_PLUIE);
	}
	
	private ReservationRequestDTO first_request_reservation(){
		// date debut reservation: 10/02/2020 - 12h00
		LocalDateTime dateDebut = LocalDateTime.of(2020, Month.APRIL, 10, 12, 00);
		// date fin  reservation:  10/02/2020 - 14h00
		LocalDateTime dateFin = LocalDateTime.of(2020, Month.APRIL, 10, 14, 00);
		
		ReservationRequestDTO request = new ReservationRequestDTO();
		request.setIdsJoueurs(new ArrayList<Long>(Arrays.asList(id_joueur_1, id_joueur_2)));
		request.setDateDebut(Date.from(dateDebut.atZone(ZoneId.systemDefault()).toInstant()));
		request.setDateFin(Date.from(dateFin.atZone(ZoneId.systemDefault()).toInstant()));
		request.setTerrainType(TerrainType.SOL_NATUREL_EXTERIEUR);
		
		return request;
	}

	
	private void create_users(){

		joueur_1 = new JoueurDTO();
		joueur_1.setFirstName("firstName_1");
		joueur_1.setPhoneNumber("060001");
		
		joueur_2 = new JoueurDTO();
		joueur_2.setFirstName("firstName_3");
		joueur_2.setPhoneNumber("060002");
		
		id_joueur_1 = joueurService.inscription(joueur_1);
		id_joueur_2 = joueurService.inscription(joueur_2);
		
	}
}
