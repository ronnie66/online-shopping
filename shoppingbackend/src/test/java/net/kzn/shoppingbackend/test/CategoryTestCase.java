package net.kzn.shoppingbackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init(){
		
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	
//	@Test
//	public void testAddCategory(){
//		
//		category = new Category();
//		category.setName("Television");
//		category.setDescription("This is a Description of Television");
//		category.setImageURL("CAT_1.png");
//		assertEquals("Successfully added a category in to database",true,categoryDAO.add(category));
//		
//		
//	}
	
//	@Test
//	public void testGetCategory(){
//		
//		category =categoryDAO.get(2);
//		
//		assertEquals("Successfully fetch a single category in to database","Television",category.getName());
//		
//		
//	}
	
//	@Test
//	public void testUpdateCategory(){
//		
//		category =categoryDAO.get(2);
//		
//		category.setName("TV");
//		
//		assertEquals("Successfully update a single category in to database",true,categoryDAO.update(category));
//		
//		
//	}
	
//	@Test
//	public void testDeleteCategory(){
//		
//		category =categoryDAO.get(2);
//				
//		assertEquals("Successfully update a single category in to database",true,categoryDAO.delete(category));
//		
//		
//	}
	
//	@Test
//	public void testListCategory(){
//						
//		assertEquals("Successfully fetch list category in to database",3 ,categoryDAO.List().size());
//		
//		
//	}
	
	@Test
	public void testCRUDCategory(){
		
		//Insert
		category = new Category();
		category.setName("Laptop");
		category.setDescription("This is a Description of Laptop");
		category.setImageURL("CAT_6.png");
		assertEquals("Successfully added a category in to database",true,categoryDAO.add(category));
		
		category = new Category();
		category.setName("Television");
		category.setDescription("This is a Description of Television");
		category.setImageURL("CAT_8.png");
		assertEquals("Successfully added a category in to database",true,categoryDAO.add(category));
		
		//Update
		category =categoryDAO.get(4);
		
		category.setName("TV");
		
		assertEquals("Successfully update a single category in to database",true,categoryDAO.update(category));
		
		//Delete
		
		assertEquals("Successfully update a single category in to database",true,categoryDAO.delete(category));
		
		assertEquals("Successfully fetch list category in to database",4 ,categoryDAO.List().size());
		
		
		
	}
	


}
