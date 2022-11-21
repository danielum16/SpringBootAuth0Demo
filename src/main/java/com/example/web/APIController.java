package com.example.web;

import com.example.evosim.Chromosome;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.model.Resp;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController
@RequestMapping(path = "api", produces = MediaType.APPLICATION_JSON_VALUE)
// For simplicity of this sample, allow all origins. Real applications should
// configure CORS for their use case.
@CrossOrigin(origins = "*")

public class APIController {

	@GetMapping(value = "/private")
	public Resp privateEndpoint(@RequestParam(value = "seq", defaultValue = "ATTA") String seq) {
		// return new Resp("All good. You can see this because you are Authenticated.");
		int fitness = Chromosome.calculateFitness(seq);
		return new Resp(String.format("input string is %s and fitness is %d", seq, fitness));
	}
}
