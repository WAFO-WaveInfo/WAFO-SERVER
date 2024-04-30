package wafo.wafoserver.folder.controller.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class FolderCreateResponse {
    private final String name;
    private final String nickname;
}
