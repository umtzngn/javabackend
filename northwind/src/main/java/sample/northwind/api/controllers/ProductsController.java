package sample.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sample.northwind.business.abstracts.ProductService;
import sample.northwind.core.utilities.results.DataResult;
import sample.northwind.core.utilities.results.Result;
import sample.northwind.entities.concretes.Product;
import sample.northwind.entities.dtos.ProductWithCategoryDto;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
	
	private ProductService productService;
		
	@Autowired
	public ProductsController(ProductService productService) {
		this.productService = productService;
	}
  

	@GetMapping("/getall")
	public DataResult<List<Product>> getAll() {
		return this.productService.getAll();
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		return this.productService.add(product) ;
		
	}
	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){
		return this.productService.getByProductName(productName);
	}
	
	@GetMapping("/getByProductNameAndCategory")
	public DataResult<Product>
	getByProductNameAndCategory(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
		return this.productService.getByProductNameAndCategory(productName, categoryId);
	}
	
	@GetMapping("/getByProductNameOrCategory")
	public DataResult<List<Product>>
	getByProductNameOrCategory(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId) {
		return this.productService.getByProductNameOrCategory(productName, categoryId);
	}
	
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
		return  this.productService.getByProductNameContains(productName);
	}
	
	@GetMapping("/getAllByPage")
	public DataResult<List<Product>> getAll(int pageNo, int pageSize){
		return this.productService.getAll( pageNo, pageSize);
	}
	
	@GetMapping("/getAllDesc")
	public DataResult<List<Product>> getAllSorted(){
		return this.productService.getAllSorted();
	}
	
	@GetMapping("/ProductWithCategoryDto")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
		return this.productService.getProductWithCategoryDetails();
	}
	
		

}
