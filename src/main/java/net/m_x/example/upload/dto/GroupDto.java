package net.m_x.example.upload.dto;

import java.io.Serializable;
import java.util.List;

public class GroupDto implements Serializable{

    private List<LineDto> rows;

    public List<LineDto> getRows() {
        return rows;
    }

    public void setRows(List<LineDto> rows) {
        this.rows = rows;
    }
}
