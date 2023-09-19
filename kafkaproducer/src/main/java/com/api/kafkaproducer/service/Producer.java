package com.api.kafkaproducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.api.kafkaproducer.model.*;

@Service
public class Producer {
	
	@Autowired
	private KafkaTemplate<String, InfraccionData> kafkaCoor;
	
	public void sendInfraccion(String kafkaTopic, InfraccionData infraccion) {
		System.out.println("Publishing to topic " + kafkaTopic);
		kafkaCoor.send(kafkaTopic, infraccion);
	}
}
