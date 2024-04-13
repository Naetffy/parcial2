package co.edu.escuelaing.cvds.lab7.controller;

import co.edu.escuelaing.cvds.lab7.model.Product;
import co.edu.escuelaing.cvds.lab7.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/api")
@CrossOrigin("*")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/products")
    @ResponseBody
    public List<Product> apiProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/products")
    @ResponseBody
    public List<Product> apiProducts(@RequestBody Product product) {
        if (product.getRating() > 5 || product.getRating() < 1){
            return null;
        }
        productService.addProduct(product);
        return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    @ResponseBody
    public Product apiProduct(@PathVariable Integer id) {
        return productService.getProduct(id);
    }
    @PutMapping("/product/{id}")
    @ResponseBody
    public Product apiProductUpdate(@PathVariable Integer id,@RequestBody Product product) {
        return productService.updateProduct(product);
    }
    @PatchMapping("/product/{id}")
    @ResponseBody
    public Product apiProductPatch(@PathVariable Integer id, @RequestBody Product product) {
        Product p = productService.getProduct(id);
        product.setId(id);
        if (product.getName()==null) product.setName(p.getName());
        if (product.getDescription()==null) product.setDescription(p.getDescription());
        if (product.getCategory()==null) product.setCategory(p.getCategory());
        if (product.getRating()==0) product.setRating(p.getRating());
        if (product.getPrice()==0) product.setPrice(p.getPrice());
        if (product.getQuantity()==0) product.setQuantity(p.getQuantity());
        productService.updateProduct(product);
        return productService.getProduct(id);
    }
    @DeleteMapping("/product/{id}")
    @ResponseBody
    public List<Product> apiProductDelete(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return productService.getAllProducts();
    }
}
