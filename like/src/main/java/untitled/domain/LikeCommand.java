package untitled.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
public class LikeCommand {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String topicId;
    private String userId;
    private Boolean likes;
}
