package net.m_x.example.upload.controller;

import net.m_x.example.upload.dao.GroupEntityDao;
import net.m_x.example.upload.dto.GroupDto;
import net.m_x.example.upload.entity.GroupEntity;
import net.m_x.example.upload.transformer.ElementTransformer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UploadController {
    private final static Logger logger = Logger.getLogger(UploadController.class);

    @Autowired
    private GroupEntityDao groupEntityDao;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public void uploadContent(@RequestParam GroupDto content) {
        logger.info("invoke request");
        GroupEntity group = new ElementTransformer(content).getGroupEntity();
        groupEntityDao.save(group);
    }
}
