package com.github.billssys.waffle.model.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.github.billssys.waffle.model.exceptions.ProductException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ProductTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Product product;

    @Before
    public void setUp() {
        try {
            product = new Product("Notebook", " Laptop for programming", 2_000.0, 100);
        } catch (ProductException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void shouldAddProducts() {
        product.addProduct(3);
        int actual = product.getQuantity();
        assertEquals(103, actual);
    }

    @Test
    public void shouldRemoveProducts() {
        try {
            product.removeProduct(6);
        } catch (ProductException e) {
            throw new RuntimeException(e);
        }
        int actual = product.getQuantity();
        assertEquals(94, actual);
    }

    @Test
    public void shouldGetInitialQuantityProducts() {
        int actual = product.getQuantity();
        assertEquals(100, actual);
    }

    @Test
    public void shouldGetInitialPriceProducts() {
        double actual = product.getPrice();
        assertEquals(2_000.0, actual, 0);
    }

    @Test
    public void shouldGetConstructorProductQuantityException() throws ProductException {
        thrown.expect(ProductException.class);
        thrown.expectMessage("Quantity cannot be negative");
        new Product("TV", "A simple TV", 100, -9);
    }

    @Test
    public void shouldGetConstructorProductPriceException() throws ProductException {
        thrown.expect(ProductException.class);
        thrown.expectMessage("Price cannot be negative");
        new Product("TV", "A simple TV", -6, 9);
    }

    @Test
    public void shouldGetRemoveProductPriceException() throws ProductException {
        thrown.expect(ProductException.class);
        thrown.expectMessage("Insufficient products");
        product.removeProduct(333);
    }

}
