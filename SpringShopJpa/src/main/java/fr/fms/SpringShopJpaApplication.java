package fr.fms;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

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
		
		//Ajouter des articles
		Category pc = categoryRepository.save(new Category("pc"));
		Category smartphone = categoryRepository.save(new Category ("smartphone"));
		Category tablet = categoryRepository.save(new Category("tablet"));
		
		//Ajouter des articles
		articleRepository.save(new Article("Apple", "MacPro", 1000, pc));
		articleRepository.save(new Article("Apple", "iPhone15", 500, smartphone));
		articleRepository.save(new Article("Apple", "iPadPro", 500, tablet));
		articleRepository.save(new Article("Dell", "Latitude", 500, tablet));
		articleRepository.save(new Article("Dell", "Insipron", 850, pc));
		articleRepository.save(new Article("Motorola", "Moto E13", 100, smartphone));
		
		
		
		System.out.println("Bienvenu dans notre application de gestion d'articles ! Vivement la couche web parce que...");
		
		Scanner scan = new Scanner(System.in);
		
		int choice = 0;
		while(choice != 12) {
			displayMenu();
			choice = scan.nextInt();
			switch(choice) {					
				case 1 : 
						System.out.println("Affichage de tous les articles sans pagination");
					break;
				case 2 : 
						System.out.println("Affichage de tous les articles avec pagination");
					break;	
				case 3 : 
						System.out.println("Marque : "); String brandAdd = scan.nextLine();
						System.out.println("Description : "); String descriptionAdd = scan.nextLine();
						System.out.println("Prix : "); double priceAdd = scan.nextDouble();
						System.out.println("Category : "); String categoryAdd = scan.nextLine();
						Category cat = categoryAdd.equals("pc") ? pc : catAdd.equals("tablet") ? tablet : catAdd.equals("smartphone") ? smartphone;
						articleRepository.save(new Article(brandAdd, descriptionAdd, priceAdd, cat));
					break;					
				case 4 : 
						System.out.println("Afficher un article par id : ");
						String art = scan.nextLine();
						articleRepository.findById();
					break;						
				case 5 : 
						System.out.println("Id de l'article à supprimer : ");
						articleRepository.deleteById();
					break;
				case 6 : 
					System.out.println("Modifier un article");
					
				break;
				case 7 : 
						System.out.println("Ajouter une categorie");
					break;
				case 8 :
						System.out.println("Afficher une catégorie : ");
						articleRepository.findByCategoryId();
					break;	
				case 9 : 
						System.out.println("Supprimer une categorie");
					break;	
				case 10 :
					System.out.println("Mettre à jour une catégorie : ");
					break;
				case 11 :
					System.out.println("Afficher tous les articles d'une categorie");
					break;	
				case 12 :
					System.out.println("Sortir du programme");
					break;	
				default : System.out.println("veuillez saisir une valeur entre 1 et 8");
					break;
			}
		}
			
}
	//Méthode qui affiche le menu
	public void displayMenu() {	
		System.out.println("1: Afficher tous les articles sans pagination");
		System.out.println("2: Afficher tous les articles avec pagination");
		System.out.println("**********************************************");
		System.out.println("3: Ajouter un article");
		System.out.println("4: Afficher un article");
		System.out.println("5: Supprimer un article");
		System.out.println("6: Modifier un article");
		System.out.println("**********************************************");	
		System.out.println("7: Ajouter une categorie");
		System.out.println("8: Afficher une categorie");
		System.out.println("9: Supprimer une categorie");
		System.out.println("11: Mettre à jour une categorie");
		System.out.println("11: Afficher tous les articles d'une categorie");
		System.out.println("**********************************************");
		System.out.println("8: Sortir du programme");
	}
}

		
		
		
	
		
	
	
	
		
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
		
		
		/*//Afficher par catégorie
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
		
		
		//tous les articles contenant telle description et telle marque
		articleRepository.findByDescriptionAndBrand("Ipad", "Apple"); {
			System.out.println(article); 
		}
		
		//Supprimer un article à partir de l'id
		articleRepository.deleteById((long) 6); {
			System.out.println(article); 
		}*/
		
		//Permettre de mettre à jour un article à partir de l'id
	  //Optional<Category> smartphone = categoryRepository.findById((long) 20);
		/*Optional<Article> article = articleRepository.findById((long) 3); 
		if (article.isPresent()) {
			article.get().setBrand("Apple");
			articleRepository.updateArticle(article.get().getId(), article.get().getBrand(), article.get().getDescription(), article.get().getPrice());
		}
		
		
		//Afficher les noms des catégories classés par ordre croissant puis décroissant
		for(Category  category : categoryRepository.findByOrderByNameAsc()) {
			System.out.println(category);
		}; 
		
		for(Category category : categoryRepository.findByOrderByNameDesc()) {
			 System.out.println(category);
			 }
		*/
	
	
		//Ajouter une méthode de mon choix - existsById
		/*Long id = (long) 15;
		if(articleRepository.existsById(id)) {
			System.out.println("Oui, ça existe!");
		} 
		else {
				System.out.println("Dommage, ça n'existe pas!");
			}
		}*/

	





