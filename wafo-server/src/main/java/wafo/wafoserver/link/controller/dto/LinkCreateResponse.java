package wafo.wafoserver.link.controller.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import wafo.wafoserver.folder.Folder;

@Getter
@RequiredArgsConstructor
public class LinkCreateResponse {
    private final String url;
    private final String title;
    private final String favicon_url;
    private final Folder folder;
}
