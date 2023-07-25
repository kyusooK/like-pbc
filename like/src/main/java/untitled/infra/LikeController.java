package untitled.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import untitled.domain.*;

@RestController
// @RequestMapping(value="/likes")
@Transactional
public class LikeController {

    @Autowired
    LikeRepository likeRepository;

    @RequestMapping(
        value = "likes/{id}/like",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Like like(
        @PathVariable(value = "id") String id,
        @RequestBody LikeCommand likeCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /like/like  called #####");
        Optional<Like> optionalLike = likeRepository.findById(id);

        optionalLike.orElseThrow(() -> new Exception("No Entity Found"));
        Like like = optionalLike.get();
        like.like(likeCommand);

        likeRepository.save(like);
        return like;
    }
}
