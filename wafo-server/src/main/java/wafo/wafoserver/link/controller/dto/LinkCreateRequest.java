package wafo.wafoserver.link.controller.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LinkCreateRequest {
    private final Long userId;
    private final String url;
    private final String title;
    private final String faviconUrl;
    private final Long folderId;
}
