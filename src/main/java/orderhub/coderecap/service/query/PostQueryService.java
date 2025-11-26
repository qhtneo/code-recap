package orderhub.coderecap.service.query;
import orderhub.coderecap.dto.response.PostResponseDto;

import java.util.List;

public interface PostQueryService {
    PostResponseDto findById(Long id);
    List<PostResponseDto> findAll();
}
