package com.example.shaurma;

import com.example.shaurma.models.Ingredient;
import com.example.shaurma.models.User;
import com.example.shaurma.repositories.IngredientRepository;
import com.example.shaurma.repositories.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ShaurmaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShaurmaApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(IngredientRepository repo) {
		return args -> {
			repo.save(new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP));
			repo.save(new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP));
			repo.save(new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN));
			repo.save(new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN));
			repo.save(new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES));
			repo.save(new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES));
			repo.save(new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE));
			repo.save(new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE));
			repo.save(new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE));
			repo.save(new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE));
		};
	}


	@Bean
	public SecurityConfig.UserDetailsService userDetailsService(UserRepository userRepo) {
		return username -> {
			User user = userRepo.findByUsername(username);
			if (user != null) return user;
			throw new UsernameNotFoundException("User ‘" + username + "’ not found");
		};
	}

}
