package wafo.wafoserver.link.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wafo.wafoserver.Result;
import wafo.wafoserver.link.controller.dto.LinkCreateRequest;
import wafo.wafoserver.link.service.LinkService;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class LinkController {
    private final LinkService linkService;

    @PostMapping("/links/new")
    public Result createLink(@RequestBody LinkCreateRequest linkCreateRequest) {
        return new Result(linkService.create(linkCreateRequest));
    }
}
