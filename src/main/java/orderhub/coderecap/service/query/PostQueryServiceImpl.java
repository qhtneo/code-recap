package orderhub.coderecap.service.query;

import lombok.RequiredArgsConstructor;
import orderhub.coderecap.dto.response.PostResponseDto;
import orderhub.coderecap.entity.Post;
import orderhub.coderecap.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostQueryServiceImpl implements PostQueryService {
    private final PostRepository postRepository;

    @Override
    public PostResponseDto findById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));
        return Post.toResponseDto(post);
    }

    @Override
    public List<PostResponseDto> findAll() {
        return postRepository.findAll().stream()
                .map(Post::toResponseDto)
                .toList();
    }
}
