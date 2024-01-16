package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.demo.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
	@Override
	public List<Product> findAllproducts() {
	
		return jdbcTemplate.query("select * from product1",(rs,num)-> {
			Product p=new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setPrice(rs.getDouble(3));
			p.setQty(rs.getInt(4));
			
			return p;
		});
	}
	@Override
	public void save(Product p) {
	
		String str="insert into product1 values(?,?,?,?)";
		jdbcTemplate.update(str,new Object[] {p.getPid(),p.getPname(),p.getQty(),p.getPrice()});
		
		}

	

}
