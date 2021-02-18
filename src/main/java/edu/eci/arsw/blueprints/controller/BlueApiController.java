package edu.eci.arsw.blueprints.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/blueprints")

public class BlueApiController {

	
	@Autowired
    @Qualifier("BlueprintsServices")
    BlueprintsServices services;
	
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> manejadorBlueprints(){
		try {
			return new ResponseEntity<>(services.getAllBlueprints(), HttpStatus.ACCEPTED);
        }catch (Exception ex) {
            Logger.getLogger(BlueApiController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error",HttpStatus.NOT_FOUND);
        }
		
		
	}
	
}
