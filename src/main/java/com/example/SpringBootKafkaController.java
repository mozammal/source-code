package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.ExecutionException;

@RestController
public class SpringBootKafkaController {

	@Autowired
	SpringBootKafkaProducer springBootKafkaProducer;

	@RequestMapping("/vote")
	public Status vote(@RequestParam(value = "name", defaultValue = "Hello Spring Kafka") String name) {

		try {
			springBootKafkaProducer.send(name);
		} catch (Exception e) {
		}
		return new Status(name);
	}

}