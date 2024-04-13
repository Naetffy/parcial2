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
        productService.addProduct(product);
        return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    @ResponseBody
    public Product apiProduct(@PathVariable Integer id) {
        return productService.getProduct(id);
    }
    @PutMapping("/product")
    @ResponseBody
    public Product apiProductUpdate(@RequestBody Product product) {
        productService.updateProduct(product);
        return productService.getProduct(product.getId());
    }
    @PatchMapping("/product")
    @ResponseBody
    public Product apiProductPatch(@RequestBody Product product) {
        productService.updateProduct(product);
        return productService.getProduct(product.getId());
    }
    @DeleteMapping("/product/{id}")
    @ResponseBody
    public List<Product> apiProductDelete(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return productService.getAllProducts();
    }
}
