package meetup.groups.repository;

import meetup.groups.model.GroupMeetUp;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupMeetUpRepository extends CrudRepository<GroupMeetUp, String> {

    public List<GroupMeetUp> findByTopicId(String topicId);

}
