package dev.danvega;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.danvega.domain.Material;
import dev.danvega.domain.MaterialesContainer;
import dev.danvega.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class JsontodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsontodbApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserService userService) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<MaterialesContainer>> typeReference = new TypeReference<List<MaterialesContainer>>() {
			};
			InputStream inputStream = JsontodbApplication.class.getResourceAsStream("/json/lista_materiales.json");
			try {
				List<MaterialesContainer> materialesContainers = mapper.readValue(inputStream, typeReference);

				// Obtén la lista de materiales del primer contenedor
				List<Material> materiales = materialesContainers.get(0).getMateriales();

				userService.save(materiales);
				System.out.println("Materiales Saved!");
			} catch (IOException e) {
				System.out.println("Unable to save materiales: " + e.getMessage());
			}
		};
	}
}
