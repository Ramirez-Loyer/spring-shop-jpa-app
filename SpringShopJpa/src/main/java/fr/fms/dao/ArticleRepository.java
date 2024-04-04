package fr.fms.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.fms.entities.Article;
import fr.fms.entities.Category;

public interface ArticleRepository extends JpaRepository<Article, Long>{
	public List<Article> findByBrand(String brand);
	public List<Article> findByBrandContains(String brand);
	public List<Article> findByBrandAndPrice(String brand, double price);
	
	@Query ("select A from Article A where A.brand like %:x% and A.price > :y")
	public List<Article> searchArticles(@Param("x") String kw, @Param("y") double price);
	
	
	public List<Article> findByCategoryId(Long categoryId);

	
	public Optional<Article> findById(Long articleId);
	

	public List<Article> findByDescriptionAndBrand(String description, String brand);
	
	
	public void deleteById(long articleId);
	
	@Transactional
	@Modifying 
	@Query ("update Article A set A.brand = :brand, A.description =:description, A.price =:price where A.id=:id")
	public void updateArticle(@Param("id")Long id,  @Param("brand")String brand, @Param("description")String description, @Param("price")double price );
	
	
	@Query("SELECT c FROM Category c ORDER BY c.name ASC, c.name DESC")
	public List<Category>findByOrderByName(@Param("name")String name);
   
	
	

}
