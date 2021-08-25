package sample.northwind.business.abstracts;


import sample.northwind.core.entities.User;
import sample.northwind.core.utilities.results.DataResult;
import sample.northwind.core.utilities.results.Result;


public interface UserService  {
		
		Result add(User user);
		DataResult<User> findByEmail(String email);
}
