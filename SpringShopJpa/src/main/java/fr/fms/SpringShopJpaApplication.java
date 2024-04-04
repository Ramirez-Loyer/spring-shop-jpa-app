package fr.fms;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;

@SpringBootApplication
public class SpringShopJpaApplication implements CommandLineRunner {
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ArticleRepository articleRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringShopJpaApplication.class, args);
	}
	
	@Override
	public void run(String...args) throws Exception {
		
		//categoryRepository.save(new Category("Smartphone"));
		
				//for(Article article : articleRepository.findByBrandAndPrice("Samsung", 250)) {
					//System.out.println(article);
				
				//for(Article article : articleRepository.searchArticles("sung", 250)) {
					//System.out.println(article);
		
		
		/*Category smartphone = categoryRepository.save(new Category ("Smartphone"));
		Category tablet = categoryRepository.save(new Category("Tablet"));
		Category pc = categoryRepository.save(new Category("PC"));
		
		articleRepository.save(new Article("Samsung", "S10", 500, smartphone));
		articleRepository.save(new Article("Samsung", "S9", 350, smartphone));
		articleRepository.save(new Article("Xiaomi", "MI10",  100, smartphone));
		
		articleRepository.save(new Article("Samsung", "GalaxyTab", 450, tablet));
		articleRepository.save(new Article("Apple", "IPad",  350, tablet));
		
		articleRepository.save(new Article("Asus", "R510", 600, pc));*/
		
		
		for(Article article : articleRepository.findByCategoryId((long) 2)) {
			System.out.println(article);
		}
		
		
		//Afficher tous les articles
		for(Article article : articleRepository.findAll()) {
			System.out.println(article);
		}
		
		//Afficher tous les articles(lambda)
		articleRepository.findAll().forEach(article -> System.out.println(article));
	
		//Afficher un article 
		Optional<Article> article = articleRepository.findById((long) 3); 
			System.out.println(article);
		
		
		
		    
		    
		    
		
	}
}


