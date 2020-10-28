package meetup.groups.model;

import meetup.topics.model.Topic;

import javax.persistence.*;

@Entity
public class GroupMeetUp {
    @Id
    private String id;
    private String name;
    private String description;

    @ManyToOne
    private Topic topic;

    public GroupMeetUp(){ }

    public GroupMeetUp(String id, String name, String description, String topicId) {
        this.id = id;
        this.name = name;
        this.description = description;
        //creating a ne topic
        this.topic = new Topic(topicId,"","");
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
