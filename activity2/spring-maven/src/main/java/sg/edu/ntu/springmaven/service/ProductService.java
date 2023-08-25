package sg.edu.ntu.springmaven.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.ntu.springmaven.POJO.Product;
import sg.edu.ntu.springmaven.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    // Dependency Injection via Constructor
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public Product getProduct(String id) {
        return productRepository.getProduct(id);
    }

    public Product addProduct(Product product) {
        return productRepository.addProduct(product);
    }

    public Product updateProduct(Product updatedProduct) {
        return productRepository.updateProduct(updatedProduct);
    }

    public Product deleteProduct(String id) {
        return productRepository.deleteProduct(id);
    }

}
