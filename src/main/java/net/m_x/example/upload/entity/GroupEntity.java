package net.m_x.example.upload.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="groups")
public class GroupEntity implements Serializable{
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "groupEntity", cascade = CascadeType.ALL)
    private List<LineEntity> lines = new ArrayList<>();

    public void add(LineEntity lineEntity) {
        this.lines.add(lineEntity);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<LineEntity> getLines() {
        return lines;
    }

    public void setLines(List<LineEntity> lines) {
        this.lines = lines;
    }

}