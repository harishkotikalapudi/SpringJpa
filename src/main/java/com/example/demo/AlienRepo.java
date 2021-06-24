package com.example.demo;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AlienRepo extends CrudRepository<Alien, Integer> {

	List<Alien> findByLang(String string);

	List<Alien> findByAidGreaterThan(int i);
	
	@Query("from Alien where lang=?1 order by aname")
	List<Alien> findByLangSorted(String lang);

}
