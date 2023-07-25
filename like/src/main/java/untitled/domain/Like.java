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
        //implement business logic here:

        LikeLiked likeLiked = new LikeLiked(this);
        likeLiked.publishAfterCommit();
    }
}
