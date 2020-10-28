package meetup.topics.controller;

import meetup.topics.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import meetup.topics.model.Topic;

import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        return topicService.getTopicList();
    }

    @RequestMapping("topics/{id}")
    public Optional<Topic> getTopicById(@PathVariable String id){//name of the {x} must be the same as the parameter x
        return topicService.getTopicId(id);
    }

    //request POST - add, create
    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic topic){//receive a Json instance, @RequestBody convert to Topic type
        topicService.addTopic(topic);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@PathVariable String id, @RequestBody Topic topic){//receive a Json instance, @RequestBody convert to Topic type
        topicService.updateTopic(id,topic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id){
         topicService.deleteTopic(id);
    }

}
