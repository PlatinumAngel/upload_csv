package net.m_x.example.upload.dto;

import java.io.Serializable;
import java.util.List;

public class LineDto implements Serializable {
    private List<String> columns;

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }
}
