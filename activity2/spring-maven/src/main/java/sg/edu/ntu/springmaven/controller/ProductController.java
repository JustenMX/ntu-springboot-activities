package sg.edu.ntu.springmaven.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.ntu.springmaven.POJO.Product;
import sg.edu.ntu.springmaven.exception.ProductNotFoundException;
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
    public ResponseEntity<List<Product>> getAllProducts() {
        try {
            return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
        } catch (ProductNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*
     * READ ONE
     * -> GET METHOD
     */

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable String id) {
        try {
            return new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
        } catch (ProductNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    /*
     * UPDATE
     * -> PUT METHOD
     */

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product updatedProduct) {
        try {
            return new ResponseEntity<>(productService.updateProduct(updatedProduct), HttpStatus.OK);
        } catch (ProductNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*
     * CREATE
     * -> POST METHOD
     */

    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        try {
            return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
        } catch (ProductNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        }

    }

    /*
     * DELETE
     * -> DELETE METHOD
     */

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable String id) {
        try {
            return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
        } catch (ProductNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
