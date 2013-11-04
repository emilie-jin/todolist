package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class Todo extends Model{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
	public Date dateCreate;
	public String label;
	
	public Todo() {
		super();
	}
	
	public static Finder<Long,Todo> find = 
            new Finder<Long, Todo>(Long.class, Todo.class);
	
	public static List<Todo> findall(){
		return find.all();
	}
	
	
	
	

}
