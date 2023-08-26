package sg.edu.ntu.springmaven.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    /*
     * UPDATE
     * -> PUT METHOD
     */

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody Product updatedProduct) {
        return productService.updateProduct(updatedProduct);
    }

    /*
     * CREATE
     * -> POST METHOD
     */

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    /*
     * DELETE
     * -> DELETE METHOD
     */

    @DeleteMapping("/products/{id}")
    public Product deleteProduct(@PathVariable String id) {
        return productService.deleteProduct(id);
    }

}
