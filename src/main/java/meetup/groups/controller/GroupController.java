package meetup.groups.controller;

import meetup.groups.model.GroupMeetUp;
import meetup.groups.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import meetup.topics.model.Topic;


import java.util.List;
import java.util.Optional;

@RestController
public class GroupController {


    @Autowired
    private GroupService groupService;


    @RequestMapping("/topics/{groupId}/groups")
    public List<GroupMeetUp> getAllGroups(@PathVariable String groupId){
        return groupService.getGroupList(groupId);
    }

    @RequestMapping("topics/{topicId}/groups/{groupId}")
    public Optional<GroupMeetUp> getGroupById(@PathVariable String groupId){//name of the {x} must be the same as the parameter x
        return groupService.getGroupId(groupId);
    }

    //request POST - add, create
    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/groups")
    public void addGroup(@RequestBody GroupMeetUp groupMeetUp, @PathVariable String topicId){
        groupMeetUp.setTopic(new Topic(topicId,"",""));
        groupService.addGroup(groupMeetUp);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/groups/{groupId}")
    public void updateGroup(@PathVariable String topicId, @PathVariable String groupId, @RequestBody GroupMeetUp groupMeetUp){
        groupMeetUp.setTopic(new Topic(topicId,"",""));
        groupService.updateGroup(groupMeetUp);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/groups/{groupId}")
    public void deleteGroup(@PathVariable String groupId){
         groupService.deleteGroup(groupId);
    }

}
