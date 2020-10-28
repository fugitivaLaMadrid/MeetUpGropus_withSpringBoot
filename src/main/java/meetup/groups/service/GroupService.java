package meetup.groups.service;

import meetup.groups.model.GroupMeetUp;
import meetup.groups.repository.GroupMeetUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    @Autowired
    private GroupMeetUpRepository groupMeetUpRepository;

    public List<GroupMeetUp> getGroupList(String topicId){

        List<GroupMeetUp> groupMeetUpList = new ArrayList<>();
        groupMeetUpRepository.findByTopicId(topicId)
                        .forEach(groupMeetUpList::add);
        return groupMeetUpList;
    }//Get request
    public Optional<GroupMeetUp> getGroupId(String groupId){
        return groupMeetUpRepository.findById(groupId);
    }

    public void addGroup(GroupMeetUp groupMeetUp) {
        groupMeetUpRepository.save(groupMeetUp);
    }

    public void updateGroup(GroupMeetUp groupMeetUp) {
    groupMeetUpRepository.save(groupMeetUp);
    }

    public void deleteGroup(String groupId) {
        groupMeetUpRepository.deleteById(groupId);
    }
}
