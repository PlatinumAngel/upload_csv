package net.m_x.example.upload.transformer;

import net.m_x.example.upload.dto.GroupDto;
import net.m_x.example.upload.dto.LineDto;
import net.m_x.example.upload.entity.ElementEntity;
import net.m_x.example.upload.entity.GroupEntity;
import net.m_x.example.upload.entity.LineEntity;

public class ElementTransformer {

    private GroupEntity groupEntity;

    public ElementTransformer(GroupDto dto) {
        groupEntity = new GroupEntity();
        for(LineDto lineDto : dto.getRows()) {
            LineEntity line = getLineEntity(lineDto);
            groupEntity.add(line);
        }
    }

    private LineEntity getLineEntity(LineDto lineDto) {
        LineEntity line = new LineEntity();
        for (String entry : lineDto.getColumns()) {
            line.add(new ElementEntity(entry));
        }
        return line;
    }

    public GroupEntity getGroupEntity() {
        return groupEntity;
    }
}
