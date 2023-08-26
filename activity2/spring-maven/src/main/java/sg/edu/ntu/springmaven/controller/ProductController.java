package sg.edu.ntu.springmaven.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.ntu.springmaven.POJO.Product;
import sg.edu.ntu.springmaven.service.ProductService;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /*
     * READ ALL
     * -> GET METHOD
     */

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    /*
     * READ ONE
     * -> GET METHOD
     */

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable String id) {
        return productService.getProduct(id);
    }

}
