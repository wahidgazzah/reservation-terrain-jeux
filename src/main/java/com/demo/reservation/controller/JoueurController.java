package com.demo.reservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.reservation.dto.JoueurDTO;
import com.demo.reservation.service.IJoueurService;

import io.swagger.annotations.Api;

/**
 * Joueur Rest Controller
 * @author wahid
 *
 */
@RestController
@RequestMapping("/joueur")
@Api(value = "JoueurController")
public class JoueurController {

	private static final Logger logger = LoggerFactory.getLogger(JoueurController.class);
	
	@Autowired
	private IJoueurService joueurService;
	
	/**
	 * inscription joueur
	 * @param dto JoueurDTO
	 * @return id 
	 */
	@RequestMapping(value = "/inscription", method = RequestMethod.POST)
	public Long inscription(@RequestBody JoueurDTO dto) {
		
		logger.info("Delegating request to Service layer.");
		
		return joueurService.inscription(dto);
	}
	
}
