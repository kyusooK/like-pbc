package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class LikeLiked extends AbstractEvent {

    private String topicId;
    private String userId;
    private Boolean likes;

    public LikeLiked(Like aggregate) {
        super(aggregate);
    }

    public LikeLiked() {
        super();
    }
}
