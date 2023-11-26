package com.riscodedit.inventory;

import com.riscodedit.inventory.domain.entity.Inventory;
import com.riscodedit.inventory.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
//		return  args -> {
//			Inventory inventory = new Inventory();
//			inventory.setSkuCode("Samsung_A73");
//			inventory.setQuantity(65);
//
//			Inventory inventory1 = new Inventory();
//			inventory1.setSkuCode("Samsung_A72");
//			inventory1.setQuantity(56);
//
//
//			Inventory inventory2 = new Inventory();
//			inventory2.setSkuCode("Samsung_A12");
//			inventory2.setQuantity(112);
//
//			Inventory inventory3 = new Inventory();
//			inventory3.setSkuCode("Samsung_S21");
//			inventory3.setQuantity(0);
//
//			inventoryRepository.save(inventory);
//			inventoryRepository.save(inventory1);
//			inventoryRepository.save(inventory2);
//			inventoryRepository.save(inventory3);
//		};
//	}

}
