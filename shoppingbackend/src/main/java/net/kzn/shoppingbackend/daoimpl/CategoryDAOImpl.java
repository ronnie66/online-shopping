package net.kzn.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	private static List<Category> categories =  new ArrayList<>();
	
//	static {
//		Category category = new Category();
//		//add first category
//		category.setId(1);
//		category.setName("Television");
//		category.setDescription("This is a Description of Television");
//		category.setImageURL("CAT_1.png");
//		
//		categories.add(category);
//		
//		//add 2nd category
//		category = new Category();
//		category.setId(2);
//		category.setName("Mobile");
//		category.setDescription("This is a Description of Mobile");
//		category.setImageURL("CAT_2.png");
//		
//		categories.add(category);
//		
//		//add 3rd category
//		category = new Category();
//		category.setId(3);
//		category.setName("Laptop");
//		category.setDescription("This is a Description of Laptop");
//		category.setImageURL("CAT_3.png");
//		
//		categories.add(category);		
//	}
	
	@Override
	public List<Category> List() {
		
		String selectActiveCategory="FROM Category WHERE active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	/*
	 * Getting single Cat base on id
	 */
	@Override
	public Category get(int id) {
		return sessionFactory.getCurrentSession().get(Category.class,Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) {
		
		try{
			sessionFactory.getCurrentSession().persist(category);			
			return true;			
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	@Transactional
	public boolean update(Category category) {
		
		try{
			sessionFactory.getCurrentSession().update(category);			
			return true;			
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}		
	}

	@Override
	@Transactional
	public boolean delete(Category category) {
		
		category.setActive(false);
		
		try{
			sessionFactory.getCurrentSession().update(category);			
			return true;			
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}		
	}

}
