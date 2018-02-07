package com.template.products.resources;

import com.template.products.exceptions.ResourceNotFoundException;
import com.template.products.models.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@Api(value="products", description="Operations to products")
public class ProductsRessource {


    @GetMapping("{productId}")
    @ApiOperation(value = "View an available product", response = Product.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved product"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    public Product getProduct(@PathVariable String productId) throws ResourceNotFoundException {
        final Product product = new Product();
        product.setId("9276f74e-a545-4cd1-89bd-d02ce0ae823e");
        product.setName("Danone chocolat");
        if(productId.equalsIgnoreCase(product.getId())){
            return product;
        }
        throw new ResourceNotFoundException(productId,"product not found");
    }
}
