package orderhub.coderecap.service.command;

import lombok.RequiredArgsConstructor;
import orderhub.coderecap.dto.request.PostCreateRequestDto;
import orderhub.coderecap.dto.response.PostResponseDto;
import orderhub.coderecap.dto.request.PostUpdateRequestDto;
import orderhub.coderecap.entity.Post;
import orderhub.coderecap.mapper.PostMapper;
import orderhub.coderecap.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostCommandServiceImpl implements PostCommandService{
    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Override
    public PostResponseDto createPost(PostCreateRequestDto request) {
        Post post = postMapper.toEntity(request);
        postRepository.save(post);

        return postMapper.toDto(post);
    }


    @Override
    public PostResponseDto updatePost(Long id, PostUpdateRequestDto request) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Post not found"));
        post.update(request.getTitle(), request.getContent());

        return postMapper.toDto(post);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
