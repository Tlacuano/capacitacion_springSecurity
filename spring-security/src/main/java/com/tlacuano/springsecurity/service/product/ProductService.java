package com.tlacuano.springsecurity.service.product;

import com.tlacuano.springsecurity.model.product.BeanProduct;
import com.tlacuano.springsecurity.model.product.ProductRepository;
import com.tlacuano.springsecurity.utils.CustomReponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    //find by id
    @Transactional(rollbackOn = Exception.class)
    public CustomReponse<BeanProduct> findProductById(Long id) {
        BeanProduct product = productRepository.findById(id).get();

        if(product == null){
            return new CustomReponse<BeanProduct>(product, "No se encontro el producto", true, 404);
        }

        return new CustomReponse<BeanProduct>(product, "Producto encontrado", false, 200);
    }

    //find all
    @Transactional(rollbackOn = Exception.class)
    public CustomReponse<List<BeanProduct>> findAllProducts() {
        List<BeanProduct> products = productRepository.findAll();

        if(products == null){
            return new CustomReponse<List<BeanProduct>>(products, "No se encontraron productos", false, 200);
        }

        return new CustomReponse<List<BeanProduct>>(products, "Productos encontrados", false, 200);
    }

    //save
    @Transactional(rollbackOn = Exception.class)
    public CustomReponse<BeanProduct> saveProduct(BeanProduct product) {
        BeanProduct productSaved = productRepository.saveAndFlush(product);

        if(productSaved == null){
            return new CustomReponse<BeanProduct>(productSaved, "No se pudo guardar el producto", true, 400);
        }

        return new CustomReponse<BeanProduct>(productSaved, "Producto guardado", false, 200);
    }

    //delete
    @Transactional(rollbackOn = Exception.class)
    public CustomReponse<String> deleteProductById(Long id) {
        productRepository.deleteById(id);
        return new CustomReponse<String>(null,"Producto eliminado", false, 200);
    }

    //update
    @Transactional(rollbackOn = Exception.class)
    public CustomReponse<BeanProduct> updateProduct(BeanProduct product) {
        BeanProduct productSaved = productRepository.saveAndFlush(product);

        if(productSaved == null){
            return new CustomReponse<BeanProduct>(productSaved, "No se pudo actualizar el producto", true, 400);
        }

        return new CustomReponse<BeanProduct>(productSaved, "Producto actualizado", false, 200);
    }

}
