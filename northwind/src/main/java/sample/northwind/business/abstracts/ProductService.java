package sample.northwind.business.abstracts;

import java.util.List;

import sample.northwind.core.utilities.results.DataResult;
import sample.northwind.core.utilities.results.Result;
import sample.northwind.entities.concretes.Product;
import sample.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductService {
	
	DataResult<List<Product>> getAll();	
	
	DataResult<List<Product>> getAll(int pageNo, int pageSize);
	
	DataResult<List<Product>> getAllSorted();
	
	Result add (Product product);
	
	
	DataResult<Product> getByProductName(String productName);
	
	DataResult<Product> getByProductNameAndCategory(String productName, int categoryId);
	
	DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId);
	
	DataResult<List<Product>> getByCategoryIn(List<Integer> categories);
	
	DataResult<List<Product>> getByProductNameContains(String productName);
	
	DataResult<List<Product>> getByProductNameStartsWith(String productName);
	
	DataResult<List<Product>> getByNameAndCategory(String productName,int categoryId);
	
	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();

}
