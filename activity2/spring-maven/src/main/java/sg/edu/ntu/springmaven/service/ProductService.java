package sg.edu.ntu.springmaven.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import sg.edu.ntu.springmaven.POJO.Product;
import sg.edu.ntu.springmaven.exception.ProductNotCreatedException;
import sg.edu.ntu.springmaven.exception.ProductNotFoundException;
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
        if (productRepository.getAllProducts().isEmpty()) {
            throw new ProductNotFoundException("Products not found");
        }
        return productRepository.getAllProducts();
    }

    public Product getProduct(String id) {
        Product product = productRepository.getProduct(id);
        if (product == null) {
            throw new ProductNotFoundException("Product not found for ID: " + id);
        }
        return productRepository.getProduct(id);
    }

    public Product addProduct(Product product) {
        Product newProduct = productRepository.addProduct(product);
        if (newProduct == null) {
            throw new ProductNotCreatedException("Could not create Product, check Product fields and try again");
        }
        return productRepository.addProduct(product);
    }

    public Product updateProduct(Product updatedProduct) {
        return productRepository.updateProduct(updatedProduct);
    }

    public Product deleteProduct(String id) {
        Product product = productRepository.deleteProduct(id);
        if (product == null) {
            throw new ProductNotFoundException("Product not found for ID: " + id);
        }
        return productRepository.deleteProduct(id);
    }

}
