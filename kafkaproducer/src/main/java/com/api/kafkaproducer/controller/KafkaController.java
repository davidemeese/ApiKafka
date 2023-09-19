package com.api.kafkaproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.kafkaproducer.model.*;
import com.api.kafkaproducer.service.Producer;

@RestController
@RequestMapping("/kafkaproducer") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/kafkaproducer/
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST}) //con origins="*" le damos permisos a todas las direcciones
public class KafkaController {
	
    @Autowired
    private Producer producer;
    
    //KafkaPost
    @PostMapping("/infracciones")
    public void sendInfracciones(@RequestParam("lat") String lat, @RequestParam("lon") String lon, 
    		@RequestParam("mat") String mat, @RequestParam("vel") String vel) {
    	InfraccionData geo = new InfraccionData(lat, lon, mat, vel);
    	producer.sendInfraccion("prueba",geo);
    } 
}
