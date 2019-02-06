package ea.mpp.library.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ea.mpp.library.entities.Address;
import ea.mpp.library.entities.Author;
import ea.mpp.library.entities.Person;

public class AuthorDAO {

	private Map<String,Author> AuthorInfoDataMap=new HashMap<String,Author>();
	
	private List<Author> authors;
	
	public AuthorDAO() {
		
		Person person1=new Person("Geofrey","Ssekirime","+1(240)-732-234",new Address("4th North Street","Fairfield","Iowa","1000"));
			
		Person person2=new Person("John","Doe","+1(240)-732-234",new Address("5th North Street","Fairfield","Iowa","1000"));
		
		Author author=new Author("Prof.","Has a Masters' Degree in Computer Science.",person1);
		Author author2=new Author("Mr.","Has a Bachelors' Degree in Computer Science", person2);
		
		AuthorInfoDataMap.put("1", author);
		AuthorInfoDataMap.put("2", author2);
			
		}
	
	public List<Author> getAuthors(){
		
		return new ArrayList<Author>(AuthorInfoDataMap.values());
	
	}
	
	public Author getAuthor(String id) {
		
		return AuthorInfoDataMap.get(id);
	}
		
	
}
