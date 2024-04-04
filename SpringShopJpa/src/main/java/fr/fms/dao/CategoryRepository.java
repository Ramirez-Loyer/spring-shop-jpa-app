package fr.fms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.fms.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	
	public List<Category>findByOrderByNameAsc();
	public List<Category>findByOrderByNameDesc();


	
	
}
