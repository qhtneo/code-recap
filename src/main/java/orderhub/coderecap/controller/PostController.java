package orderhub.coderecap.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import orderhub.coderecap.dto.request.PostCreateRequestDto;
import orderhub.coderecap.dto.response.PostResponseDto;
import orderhub.coderecap.dto.request.PostUpdateRequestDto;
import orderhub.coderecap.service.command.PostCommandService;
import orderhub.coderecap.service.query.PostQueryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostCommandService postCommandService;
    private final PostQueryService postQueryService;

    // Create
    @PostMapping
    public PostResponseDto createPost(@Valid @RequestBody PostCreateRequestDto request) {
        return postCommandService.createPost(request);
    }

    // Update
    @PutMapping("/{id}")
    public PostResponseDto updatePost(@PathVariable Long id, @Valid @RequestBody PostUpdateRequestDto request) {
        return postCommandService.updatePost(id, request);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postCommandService.deletePost(id);
    }

    // READ ONE
    @GetMapping("/{id}")
    public PostResponseDto getPost(@PathVariable Long id) {
        return postQueryService.findById(id);
    }

    // READ ALL
    @GetMapping
    public List<PostResponseDto> getAllPosts() {
        return postQueryService.findAll();
    }
}
