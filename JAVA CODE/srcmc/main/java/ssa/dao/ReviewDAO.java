package ssa.dao;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import ssa.entity.Review;

@Transactional
@Repository
public class ReviewDAO implements IReviewDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked")
    @Override
	public List<Review> getReviewsById(int class_id) {
		 String hql = "FROM Review where class_id = '" + class_id + "'";
	     return (List<Review>) hibernateTemplate.find(hql);
	}
    
    
    public Review getReviewById(int id) {
		 String hql = "FROM Review where id = '" + id + "'";
	     return (Review) hibernateTemplate.find(hql).get(0);
	}
    
//    @Override
//	public List<Review> getReviewsByProfessor(int class_id) {
//		 String hql = "FROM Review where class_id = '" + class_id + "'";
//	     return (List<Review>) hibernateTemplate.find(hql);
//	}
	
	@Override
	public void deleteReview(int id) {
	    Review review = getReviewById(id);
	    hibernateTemplate.delete(review);
	}

	
	@Override
	public void insertReview(Review Review) {
	    hibernateTemplate.save(Review);
	}
	
	@Override
	public void updateReview(Review Review) {
	    hibernateTemplate.update(Review);
	}

}


