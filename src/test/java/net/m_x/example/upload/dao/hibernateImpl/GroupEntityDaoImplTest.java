package net.m_x.example.upload.dao.hibernateImpl;

import net.m_x.example.upload.dao.GroupEntityDao;
import net.m_x.example.upload.entity.ElementEntity;
import net.m_x.example.upload.entity.GroupEntity;
import net.m_x.example.upload.entity.LineEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:test-context.xml" })
public class GroupEntityDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests{

    @Autowired
    private GroupEntityDao groupEntityDao;

    @Test
    public void cascadeSaveTest() {
        //Given
        GroupEntity groupEntity = new GroupEntity();
        LineEntity lineEntity = new LineEntity();
        groupEntity.add(lineEntity);
        lineEntity.add(new ElementEntity("First"));
        lineEntity.add(new ElementEntity("Second"));

        //When
        groupEntityDao.save(groupEntity);

        //Then
        assertNotNull(groupEntity.getId());
        assertNotNull(groupEntity.getLines());
        assertEquals(1, groupEntity.getLines().size());
        assertNotNull(lineEntity.getId());
        assertNotNull(lineEntity.getElements());
        assertEquals(2, lineEntity.getElements().size());
        assertNotNull(lineEntity.getElements().get(0).getId());
        assertEquals("First", lineEntity.getElements().get(0).getValue());
        assertNotNull(lineEntity.getElements().get(1).getId());
        assertEquals("Second", lineEntity.getElements().get(1).getValue());
    }
}