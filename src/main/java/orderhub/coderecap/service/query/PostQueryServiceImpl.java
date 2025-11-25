package orderhub.coderecap.service.query;

import lombok.RequiredArgsConstructor;
import orderhub.coderecap.dto.response.PostResponseDto;
import orderhub.coderecap.mapper.PostMapper;
import orderhub.coderecap.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostQueryServiceImpl implements PostQueryService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Override
    public PostResponseDto findById(Long id) {
        return postRepository.findById(id).map(postMapper::toDto)
                .orElseThrow(()-> new IllegalArgumentException("Post not found"));
    }

    @Override
    public List<PostResponseDto> findAll() {
        return postRepository.findAll().stream().map(postMapper::toDto).toList();
    }
}
