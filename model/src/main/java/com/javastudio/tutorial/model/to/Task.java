package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.Auditable;
import com.javastudio.tutorial.model.base.EntityBase;
import com.javastudio.tutorial.model.listener.AuditListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Task")
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "TASK_SEQ")
@NamedQueries({
        @NamedQuery(name = Task.FIND_ALL, query = "select t from Task t"),
})
@EntityListeners(AuditListener.class)
public class Task extends EntityBase implements Auditable {

    public static final String FIND_ALL = "Task.findAll";

    @Column(name = "TASK_DESCRIPTION", length = 400)
    String taskDescription;


    String title;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    List<TaskComment> comments = new ArrayList<>();

    @OneToOne(
            mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY
    )
    private TaskDetails details;

    @ManyToMany
    @JoinTable(
            name = "task_tag",
            joinColumns = @JoinColumn(
                    name = "task_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "tag_id"
            )
    )
    private List<Tag> tags = new ArrayList<>();

//    private Date dateOfBirth;

    @Transient
    private int age;

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

//    @PostLoad
//    public void calculateAge() {
//        Calendar birth = new GregorianCalendar();
//        birth.setTime(dateOfBirth);
//        Calendar now = new GregorianCalendar();
//        now.setTime( new Date() );
//        int adjust = 0;
//        if ( now.get(Calendar.DAY_OF_YEAR) - birth.get(Calendar.DAY_OF_YEAR) < 0) {
//            adjust = -1;
//        }
//        age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR) + adjust;
//    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<TaskComment> getComments() {
        return comments;
    }

    public void setComments(List<TaskComment> comments) {
        this.comments = comments;
    }

    public TaskDetails getDetails() {
        return details;
    }

    public void setDetails(TaskDetails details) {
        this.details = details;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
