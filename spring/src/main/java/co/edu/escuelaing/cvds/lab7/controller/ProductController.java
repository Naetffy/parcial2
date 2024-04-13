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

    @GetMapping("/product")
    @ResponseBody
    public List<Product> apiProduct(@RequestParam(name="id", required=true, defaultValue="1") Integer id) {
        return (List<Product>) productService.getProduct(id);
    }
    @PutMapping("/product")
    @ResponseBody
    public List<Product> apiProductUpdate(@RequestBody Product product) {
        productService.updateProduct(product);
        return (List<Product>) productService.getProduct(product.getId());
    }
    @PatchMapping("/product")
    @ResponseBody
    public List<Product> apiProductPatch(@RequestBody Product product) {
        productService.updateProduct(product);
        return (List<Product>) productService.getProduct(product.getId());
    }
    @DeleteMapping("/product")
    @ResponseBody
    public List<Product> apiProductDelete(@RequestParam(name="id", required=true, defaultValue="1") Integer id) {
        productService.deleteProduct(id);
        return productService.getAllProducts();
    }
}
