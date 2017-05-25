package net.m_x.example.upload.dao.hibernateImpl;

import net.m_x.example.upload.dao.GroupEntityDao;
import net.m_x.example.upload.entity.GroupEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class GroupEntityDaoImpl implements GroupEntityDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(GroupEntity groupEntity) {
        sessionFactory.getCurrentSession().saveOrUpdate(groupEntity);
        sessionFactory.getCurrentSession().flush();
    }
}
