package net.m_x.example.upload.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="lines")
public class LineEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "line", cascade = CascadeType.ALL)
    private List<ElementEntity> elements = new ArrayList();

    @ManyToOne
    @JoinColumn(name="group_FK")
    private GroupEntity groupEntity;

    public void add(ElementEntity element) {
        this.elements.add(element);
    }

    public GroupEntity getGroupEntity() {
        return groupEntity;
    }

    public void setGroupEntity(GroupEntity groupEntity) {
        this.groupEntity = groupEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ElementEntity> getElements() {
        return elements;
    }

    public void setElements(List<ElementEntity> elements) {
        this.elements = elements;
    }
}
