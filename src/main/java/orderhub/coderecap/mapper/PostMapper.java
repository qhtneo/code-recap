package orderhub.coderecap.mapper;

import orderhub.coderecap.dto.request.PostCreateRequestDto;
import orderhub.coderecap.dto.response.PostResponseDto;
import orderhub.coderecap.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(target = "id", ignore = true)
    PostResponseDto toDto(Post post);

    Post toEntity(PostCreateRequestDto request);
}
