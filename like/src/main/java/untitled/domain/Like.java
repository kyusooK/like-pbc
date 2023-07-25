package untitled.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.LikeApplication;

@Entity
@Table(name = "Like_table")
@Data
public class Like {

    @Id
    private String topicId;

    private String userId;

    private Boolean likes;

    @PostPersist
    public void onPostPersist() {}

    public static LikeRepository repository() {
        LikeRepository likeRepository = LikeApplication.applicationContext.getBean(
            LikeRepository.class
        );
        return likeRepository;
    }

    public void like(LikeCommand likeCommand) {
        //implement business logic here: Create new Like if there`s no topicId or load the existing entity with the topicId. and add the userId and likes.
        Like like = repository().findByTopicId(likeCommand.getTopicId());
        if (like == null) {
            like = new Like();
            like.setTopicId(likeCommand.getTopicId());
        }
        like.setUserId(likeCommand.getUserId());
        like.setLikes(likeCommand.getLikes());
        repository().save(like);
    
        // publish event to the external world
        LikeLiked likeLiked = new LikeLiked(this);
        likeLiked.publishAfterCommit();
    }
}
