package com.distribuida.rest;

import com.distribuida.db.Books;
import com.distribuida.servicios.IBookService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

/**
 * GET              /books/{id}         buscar1
 * GET              /books              listar todos
 * POST             /books              insertar
 * PUT/PATCH        /books/{id}         actualizar
 * DELETE           /books/{id}         eliminar
 */

@ApplicationScoped
@Path("/books")
public class BookRest {
    @Inject
    private IBookService bookService;


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Books findById(@PathParam("id") Integer id) {
        return bookService.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Books> findAll() {
        return bookService.findAll();
    }

    @POST
    @Path("/{isbn},{title},{author},{price}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(@PathParam("isbn") String isbn, @PathParam("title") String title,
                       @PathParam("author") String author, @PathParam("price") Double price) {
        Books newBook = new Books(isbn, title, author, price);
        bookService.createBook(newBook);
    }

    @PUT
    @Path("/{id},{isbn},{title},{author},{price}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("id") Integer id, @PathParam("isbn") String isbn, @PathParam("title") String title,
                       @PathParam("author") String author, @PathParam("price") Double price) {
        Books updateBook = new Books(id, isbn, title, author, price);
        bookService.updateBook(updateBook);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") Integer id) {

        bookService.deleteBook(id);
    }

}
