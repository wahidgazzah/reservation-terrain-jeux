# reservation-terrain-jeux
Une application REST en Spring Boot de réservation de terrain des Jeux

### Environnement Technique:
- Spring MVC,
- Spring Data,
- JPA,
- Hibernate Criteria,
- Swagger,
	
### Couches technique de l'application:
- Couche REST,
- Couche Service,
- Couche Domaine,
- Couche Persistence,

### Base des données: la base en mémoire H2

### L'application est lancée en spring-boot sur le port par défaut [server.port=8282]

### Swagger est disponible sur http://localhost:8282/swagger-ui.html

### Pour tester l'application:

Créer des joueurs on utilisant l'action POST sur le controller joueurController [joueur/inscription], avec un objet de type JoueurDTO comme @RequestBody: 

	{
	  "firstName": "gazzah",
	  "lastName": "wahid",
	  "phoneNumber": "0600000001"
	} 

Créer une reservation on utilisant l'action POST sur le controller reservationController [/reservation/reservation], avec un objet de type ReservationRequestDTO comme @RequestBody:

	{
	  "dateDebut": "2020-02-09T12:00:00.000Z",
	  "dateFin": "2020-02-09T16:00:00.000Z",
	  "idsJoueurs": [1,2,3],
	  "terrainType": "SOL_NATUREL_EXTERIEUR"
	}
	
	
