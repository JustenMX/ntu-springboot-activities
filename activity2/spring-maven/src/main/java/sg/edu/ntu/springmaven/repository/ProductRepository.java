package sg.edu.ntu.springmaven.repository;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;

import sg.edu.ntu.springmaven.POJO.Product;

@Repository
public class ProductRepository {
    private List<Product> productList = new ArrayList<>();

    public ProductRepository() {
        productList.add(new Product("1", "Product A", 10.0, "Description A"));
        productList.add(new Product("2", "Product B", 15.0, "Description B"));
        productList.add(new Product("3", "Product C", 20.0, "Description C"));
        productList.add(new Product("4", "Product D", 25.0, "Description D"));
        productList.add(new Product("5", "Product E", 30.0, "Description E"));

    }

    /*
     * READ ALL
     */

    public List<Product> getAllProducts() {
        return productList;
    }

    /*
     * READ ONE
     */

    public Product getProduct(String id) {
        for (Product product : productList) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    /*
     * CREATE
     */

    public Product addProduct(Product product) {
        productList.add(product);
        return product;
    }

    /*
     * UPDATE
     */

    public Product updateProduct(Product updatedProduct) {
        for (Product currentProduct : productList) {
            if (currentProduct.getId().equals(updatedProduct.getId())) {
                currentProduct.setName(updatedProduct.getName());
                currentProduct.setPrice(updatedProduct.getPrice());
                currentProduct.setDescription(updatedProduct.getDescription());
                return currentProduct;
            }
        }
        return null;
    }

    /*
     * DELETE
     */

    public Product deleteProduct(String id) {
        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            if (product.getId().equals(id)) {
                productList.remove(i);
                return product;
            }
        }
        return null;
    }

}
