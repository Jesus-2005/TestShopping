package es.iessoterohernandez.daw.endes.TestShopping;


import static org.junit.Assert.fail;


import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestShoppingCart {
	private static ShoppingCart s;

	@BeforeEach
	public void init() {
		s = new ShoppingCart();
	}

	// Cuando se crea, el carro tiene 0 elementos.

	@Test
	public void testElementoCreacion() {
		assertThat(s.getItemCount(), is(0));
	}

	// Cuando está vacío, el carro tiene 0 elementos.
	@Test
	public void testElementoVacio() {
		s.empty();
		assertThat(s.getItemCount(), is(0));
	}

	// Cuando se añade un producto, el número de elementos debe incrementarse.
	@Test
	public void testIncrementoElemento() {
		s.addItem(new Product("Patata",3.12));
		s.addItem(new Product("ArenaGato",5.50));
		assertThat(s.getItemCount(), is(2));
	}
	
	//Cuando se añade un producto, el balance nuevo debe ser la suma del balance anterior y el precio del producto añadido.
	@Test
	public void testBalance() {
		s.addItem(new Product("Patata",3.50));
		s.addItem(new Product("ArenaGato",5.50));
		assertThat(s.getBalance(), is(9.00));
	}
	
	//Cuando se elimina un producto, el número de elementos debe decrementarse.
	
	@Test
	public void testDecrementoElemento() throws ProductNotFoundException {
		Product p1 = new Product("Patata",3.12);
		Product p2 = new Product("ArenaGato",5.50);
		s.addItem(p1);
		s.addItem(p2);
		s.removeItem(p1); 
		assertThat(s.getItemCount(), is(1));
	}
	
	//Cuando se intenta eliminar un producto que no está en el carro, se debe lanzar una excepción ProductNotFoundException. Pista: inserta la llamada en un bloque try y pon un método fail() después de la llamada a removeItem()
	@Test
	public void testException() throws ProductNotFoundException{
		Product p1 = new Product("Patata",3.12);
		Product p2 = new Product("ArenaGato",5.50);
		s.addItem(p1);
		try {
			s.removeItem(p2);
            fail();

		}catch(ProductNotFoundException e) {
			
		}
		 
		
	}
}
