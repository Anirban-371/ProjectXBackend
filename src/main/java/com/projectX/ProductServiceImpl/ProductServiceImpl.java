package com.projectX.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import com.projectX.ProductRepository.ProductRepository;
import com.mongodb.DBObject;
import com.projectX.Admin.AdminAssets;
import com.projectX.Product.Product;
import com.projectX.Product.QProduct;
import com.projectX.Product.Request.ProductRequest;
import com.projectX.Product.Response.ProductResponse;
import com.projectX.ProductService.ProductService;
import com.querydsl.core.types.dsl.BooleanExpression;


@EnableMongoRepositories(basePackageClasses = ProductRepository.class)
@Service
public class ProductServiceImpl implements ProductService {
	
	private final MongoTemplate mongoTemplate;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
    public ProductServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
	

	@Override
	public ProductResponse getProduct(String id) {
		ProductResponse productResponse=new ProductResponse();
		List<Product> productlist =new ArrayList<>();
		Optional<Product> productdetailslist =  productRepository.findById(id);
		if(productdetailslist.isPresent()) {
			productlist.add(productdetailslist.get());
		}
		productResponse.setProductList(productlist);
		return productResponse;
	}

	@Override
	public ProductResponse getAllProduct() {
		ProductResponse productResponse =new ProductResponse();
		List<Product> productlist =new ArrayList<>();
		productRepository.findAll()
		.forEach(productlist :: add);
		productResponse.setProductList(productlist);
		return productResponse;
	}

	@Override
	public boolean addProduct(ProductRequest productRequest) {
		Product product = productRequest.getProduct();
		if(Float.parseFloat(product.getSpecs().getProductOldPrice()) > 0 
				&& Float.parseFloat(product.getSpecs().getProductPrice()) > 0) {
			double oldprice = Float.parseFloat(product.getSpecs().getProductOldPrice());
			double newprice = Float.parseFloat(product.getSpecs().getProductPrice());
			double percent = 0.0;
			if( oldprice > newprice){
				percent = -(((oldprice-newprice)/ oldprice) *100);
			}else {
				percent = ((newprice-oldprice)/ newprice) *100;
			}
			product.setOffpercent(percent);
		}
		try {
			if(product.getProductId() == null)
				productRepository.insert(product);
			else
				productRepository.save(product);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void updateProduct(ProductRequest product) {
		if(product.getProduct().getProductId() == null)
			productRepository.insert(product.getProduct());
		else
			productRepository.save(product.getProduct());
	}

	@Override
	public ProductResponse searchProduct(String itemname) {
		ProductResponse productResponse=new ProductResponse();
		QProduct qProduct = new QProduct("Product");
		BooleanExpression filterbyname = qProduct.productName.contains(itemname);
		List<Product> productList = (List<Product>) this.productRepository.findAll(filterbyname);
		productResponse.setProductList(productList);
		return productResponse;
	}
	@Override
	public List<String> getOwnerIDs() {
		System.out.println("Inside get Owner Ids Impl::");
		Aggregation aggregation = newAggregation(group("productOwnerId"));
		System.out.println("Inside Aggregation:");
		AggregationResults<Product> groupResults = mongoTemplate.aggregate(aggregation, Product.class, Product.class);
		System.out.println("Inside Aggregation value:"+ groupResults);
		List<String> productOwnerlist =new ArrayList<String>();
		groupResults.forEach(ownerID ->{
			System.out.println("Owner ID:"+ ownerID.getProductId());
			productOwnerlist.add(ownerID.getProductId());
		});
		System.out.println("Inside Product owner list result:"+ productOwnerlist);
		if(productOwnerlist.size() >0) {
			System.out.println("Size::"+ productOwnerlist.size());
			System.out.println(productOwnerlist);
			return productOwnerlist;
		}
		return null;
	}
	@Override
	public List<Product> getOwnerProducts(String ownerID) {
		System.out.println("Inside get Owner Ids Impl::");
		List<Product> productList = (List<Product>) this.productRepository.findAllProductOfOwners(ownerID);
		System.out.println(productList);	
		/*if(null == productList || productList.size()==0) {
			Optional <Product> optionalproductList = this.productRepository.findById(ownerID);
			productList = (List<Product>) ;
		}*/
		return productList;
	}
	
	public boolean addAdminAssets(AdminAssets adminAssets) {
		return false;
	}
	@Override
	public ProductResponse deleteProduct(String[] productIdList) {
		for (String id : productIdList) {
			try {
				//assetId = assetId.
				if(id != null) {
					System.out.println(id);
					this.productRepository.deleteById(id);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return getAllProduct();
	}
}
