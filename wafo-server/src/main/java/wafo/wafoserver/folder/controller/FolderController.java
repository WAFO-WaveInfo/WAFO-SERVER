package wafo.wafoserver.folder.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wafo.wafoserver.Result;
import wafo.wafoserver.account.user.repository.UserRepository;
import wafo.wafoserver.folder.controller.dto.FolderCreateRequest;
import wafo.wafoserver.folder.repository.FolderRepository;
import wafo.wafoserver.folder.service.FolderService;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class FolderController {
    private final UserRepository userRepository;
    private final FolderRepository folderRepository;
    private final FolderService folderService;

    @PostMapping("/folders/new")
    public Result create(@RequestBody FolderCreateRequest folderCreateRequest) {
        return new Result(folderService.create(folderCreateRequest));
    }

}
