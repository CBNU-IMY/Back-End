package com.example.g_server.Repository;

import com.example.g_server.Domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class JpaUserRepository implements UserRepository{

    // eitity 메니저 주입받아 사용 (엔터디 메니저는 crud 엔터티에 관련된 모든일을 처리)
    private final EntityManager em;
    public JpaUserRepository(EntityManager em){
        this.em=em;
    }

    @Override
    public User sign_up(User user) {
        em.persist(user);
        return user;
    }

    @Override
    public Optional<User> findById(int user_id) {
        User user = em.find(User.class, user_id);
        return Optional.ofNullable(user);
    }

    @Override
    public List<User> findAll() {
        //member 객체 자체를 select
        return em.createQuery("select m from User m", User.class).getResultList();

    }

}
