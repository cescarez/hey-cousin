package com.escarezapi.heycousin;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import config.FirebaseAdminConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static java.util.Objects.isNull;

@SpringBootApplication
@RestController
public class HeyCousinApplication {
	private Firestore db = FirebaseAdminConfig.getDb();

	public static void main(String[] args) {
		SpringApplication.run(HeyCousinApplication.class, args);

	}

	@GetMapping("/hello")
	String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/cousins")
	List<Cousin> getAllCousins() throws ExecutionException, InterruptedException {
	    ApiFuture<QuerySnapshot> future = db.collection("cousins").get(); //call database and return all names -- implement generics here
		List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		List<Cousin> allCousins = null;
		for (QueryDocumentSnapshot document : documents) {
			Cousin thisCousin = document.toObject(Cousin.class);
			System.out.println(document.getId() + " => " + thisCousin);
			allCousins.add(thisCousin);
		}
		return allCousins;
	}

	@PostMapping("/cousins")
	void newCousin(@RequestBody Cousin newCousin) {
		//Generate an id
		DocumentReference addedDocRef = db.collection("cousins").document();
		newCousin.setId(addedDocRef.getId());
		//add document data
		ApiFuture<WriteResult> writeResult = addedDocRef.set(newCousin);

		System.out.println("Added cousin: " + writeResult.toString());

		return;
	}

	@GetMapping("/cousins/{id}")
	Cousin getCousin(@PathVariable String id) throws ExecutionException, InterruptedException {
		ApiFuture<QuerySnapshot> future = db.collection("cousins").whereEqualTo("id", id).get(); //call database and search for cousin by id, assigning to local

		Cousin found = null;
		try {
			found = future.get().getDocuments().get(0).toObject(Cousin.class);

			//TODO: add exception if more than one cousin is found.
			// for (DocumentSnapshot document : future.get().getDocuments()) {
			// System.out.println(document.getId());
			// }
		} finally {
			if (isNull(found)) {
				throw new CousinNotFoundException(id);
			} else {
				return found; //return results of fuzzy search
			}
		}
	}

	@PutMapping("/cousins/{id}")
	Cousin updateCousin(@RequestBody Cousin updatedCousin, @PathVariable String id) {
		Cousin updated = null; // call database and
		return updated;
	}

	@DeleteMapping("/cousins/{id}")
	void deleteCousin(@PathVariable String id) {
		//delete by id from database
		ApiFuture<QuerySnapshot> future = db.collection("cousins").document("DC").delete(); //call database and search for cousin by id, assigning to local
	}
}
