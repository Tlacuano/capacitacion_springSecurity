package com.tlacuano.springsecurity.controller.product;

import com.tlacuano.springsecurity.model.product.BeanProduct;
import com.tlacuano.springsecurity.service.product.ProductService;
import com.tlacuano.springsecurity.utils.CustomReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/product")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService service;

    //find by id
    @PostMapping("/findProductById")
    public ResponseEntity<CustomReponse<BeanProduct>> findProductById(@RequestBody Long id) {
        return ResponseEntity.ok(service.findProductById(id));
    }

    //find all
    @PostMapping("/findAllProducts")
    public ResponseEntity<CustomReponse<List<BeanProduct>>> findAllProducts() {
        return ResponseEntity.ok(service.findAllProducts());
    }

    //save
    @PostMapping("/saveProduct")
    public ResponseEntity<CustomReponse<BeanProduct>> saveProduct(@RequestBody BeanProduct product) {
        return ResponseEntity.ok(service.saveProduct(product));
    }

    //delete
    @PostMapping("/deleteProductById")
    public ResponseEntity<CustomReponse<String>> deleteProductById(@RequestBody Long id) {
        return ResponseEntity.ok(service.deleteProductById(id));
    }

    //update
    @PostMapping("/updateProduct")
    public ResponseEntity<CustomReponse<BeanProduct>> updateProduct(@RequestBody BeanProduct product) {
        return ResponseEntity.ok(service.updateProduct(product));
    }
}
