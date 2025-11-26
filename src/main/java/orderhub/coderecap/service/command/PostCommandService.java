package orderhub.coderecap.service.command;

import orderhub.coderecap.dto.request.PostCreateRequestDto;
import orderhub.coderecap.dto.response.PostResponseDto;
import orderhub.coderecap.dto.request.PostUpdateRequestDto;

public interface PostCommandService {
    PostResponseDto createPost(PostCreateRequestDto request);
    PostResponseDto updatePost(Long id, PostUpdateRequestDto request);
    void deletePost(Long id);
}
