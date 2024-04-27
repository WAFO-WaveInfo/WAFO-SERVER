package wafo.wafoserver.folder.controller.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class FolderCreateRequest {
    private final String name;
    private final Long userId;
}
