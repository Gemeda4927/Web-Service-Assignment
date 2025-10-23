package com.example.restservice.resource;

import com.example.restservice.model.Product;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    private final ConcurrentHashMap<Long, Product> products = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public ProductResource() {
        initializeSampleData();
    }

    private void initializeSampleData() {
        Product p1 = new Product(idCounter.getAndIncrement(), "Laptop", "High-performance laptop", 999.99,
                "Electronics");
        Product p2 = new Product(idCounter.getAndIncrement(), "Smartphone", "Latest smartphone", 699.99, "Electronics");
        Product p3 = new Product(idCounter.getAndIncrement(), "Book", "Programming guide", 49.99, "Books");

        products.put(p1.getId(), p1);
        products.put(p2.getId(), p2);
        products.put(p3.getId(), p3);
    }

    @GET
    public Response getAllProducts() {
        List<Product> productList = new ArrayList<>(products.values());
        return Response.ok(productList).build();
    }

    @GET
    @Path("/{id}")
    public Response getProductById(@PathParam("id") Long id) {
        Product product = products.get(id);
        if (product == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Product not found with id: " + id)
                    .build();
        }
        return Response.ok(product).build();
    }

    @POST
    public Response createProduct(Product product) {
        if (product.getName() == null || product.getName().trim().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Product name is required")
                    .build();
        }

        Long newId = idCounter.getAndIncrement();
        product.setId(newId);
        products.put(newId, product);

        return Response.status(Response.Status.CREATED)
                .entity(product)
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response updateProduct(@PathParam("id") Long id, Product updatedProduct) {
        if (!products.containsKey(id)) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Product not found with id: " + id)
                    .build();
        }

        updatedProduct.setId(id);
        products.put(id, updatedProduct);

        return Response.ok(updatedProduct).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id") Long id) {
        Product removedProduct = products.remove(id);
        if (removedProduct == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Product not found with id: " + id)
                    .build();
        }
        return Response.ok().entity("Product deleted successfully").build();
    }

    @GET
    @Path("/category/{category}")
    public Response getProductsByCategory(@PathParam("category") String category) {
        List<Product> filteredProducts = products.values().stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                .toList();
        return Response.ok(filteredProducts).build();
    }
}
