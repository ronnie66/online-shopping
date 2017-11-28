package net.kzn.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories =  new ArrayList<>();
	
	static {
		Category category = new Category();
		//add first category
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is a Description of Television");
		category.setImageURL("CAT_1.png");
		
		categories.add(category);
		
		//add 2nd category
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is a Description of Mobile");
		category.setImageURL("CAT_2.png");
		
		categories.add(category);
		
		//add 3rd category
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is a Description of Laptop");
		category.setImageURL("CAT_3.png");
		
		categories.add(category);		
	}
	
	@Override
	public List<Category> List() {
		return categories;
	}

	@Override
	public Category get(int id) {
		//for loop
		for(Category category : categories)
		{
			if(category.getId() == id)
			{
				return category;
			}
		}
		return null;
	}

}