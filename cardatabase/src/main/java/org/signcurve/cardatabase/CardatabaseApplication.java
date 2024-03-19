package org.signcurve.cardatabase;

import java.util.Arrays;
import java.util.List;

import org.signcurve.cardatabase.domain.AppUser;
import org.signcurve.cardatabase.domain.AppUserRepository;
import org.signcurve.cardatabase.domain.Car;
import org.signcurve.cardatabase.domain.CarRepository;
import org.signcurve.cardatabase.domain.Owner;
import org.signcurve.cardatabase.domain.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);
    
    private final CarRepository repository;
    private final OwnerRepository orepository;
   
    
    public CardatabaseApplication(CarRepository repository,
    		                       OwnerRepository orepository) {
    	this.repository = repository;
    	this.orepository = orepository;
    }
    
	public static void main(String[] args) {
		// After adding this comment the application restarted
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Application started");
	}
	
	@Override
	public void run(String... ars) throws Exception {
		
		Owner owner1 = new Owner("John", "Johnson");
		Owner owner2 = new Owner("Mary", "Robinson");
		orepository.saveAll(Arrays.asList(owner1, owner2));
		repository.save(new Car("Ford", "Mustang", "Red", 
				"ADF-1121", 2023, 59000, owner1));
		repository.save(new Car("Nissan", "Leaf", "White", 
				"SSJ-3002", 2020, 29000, owner2));
		repository.save(new Car("Toyota", "Prius","Silver",
				"KKO-0212", 2022, 39000, owner2));
		
		
		for (Car car : repository.findAll()) {
			logger.info("brand: {}, model: {}, owner: {}", car.getBrand(),
					car.getModel() );
		}
		
		
		
		/*
		List<Car> cars = repository.findByBrand("Ford");
		logger.info("brand: {}, model: {}, owner: {}", cars.getFirst().getBrand(),
				cars.getFirst().getModel(), cars.getFirst().getOwner());
		
		List<Car> cars1 = repository.findByBrandEndsWith("Toyota");
		logger.info("brand1: {}, model1: {}, owner: {}", cars1.getFirst().getBrand(),
				cars1.getFirst().getModel(), cars1.getFirst().getOwner());
		*/
	}

}
