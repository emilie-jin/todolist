package controllers;

import java.util.Date;
import java.util.List;

import play.*;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
    	List<Todo> todos;
    	todos = Todo.findall();
    	if(request().accepts("text/html"))
    		return ok(index.render("YOUR TODOS"));
    	else if(request().accepts("application/json"))
    		return ok(Json.toJson(todos));
    	else if(request().accepts("application/rdf+xml"))
    		return ok("this will be rdf xml");
    	return badRequest();
        
    }
    final static Form<Todo> todoForm =Form.form(Todo.class);
    public static Result nouveauTodo(){
    	DynamicForm requestfdata = Form.form().bindFromRequest();
    	Todo todo = new Todo();
    	todo.label=requestfdata.get("label");
    	todo.date=new Date();
    	todo.save();
    	return ok(index.render("YOUR TODOS"));
    }

}
