package hu.neuron.junior.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.neuron.junior.core.entity.User;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public interface UserDao extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
