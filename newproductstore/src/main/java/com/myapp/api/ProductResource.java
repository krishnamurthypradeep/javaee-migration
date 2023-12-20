package com.myapp.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject
    private ProductService service;

    @GET

    public Response getProducts() {
      List<Product> products =  service.findAll();
      if(products.isEmpty()){
          return Response.noContent().build();
      }
        else
        return Response.ok(products).build();
    }
}
