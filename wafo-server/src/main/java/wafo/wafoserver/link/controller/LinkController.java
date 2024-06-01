package wafo.wafoserver.link.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wafo.wafoserver.Result;
import wafo.wafoserver.link.controller.dto.GetLinksRequest;
import wafo.wafoserver.link.controller.dto.GetLinksResponse;
import wafo.wafoserver.link.controller.dto.LinkCreateRequest;
import wafo.wafoserver.link.repository.LinkRepository;
import wafo.wafoserver.link.service.LinkService;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LinkController {
    private final LinkService linkService;
    private final LinkRepository linkRepository;

    @PostMapping("/links/new")
    public Result createLink(@RequestBody LinkCreateRequest linkCreateRequest) {
        return new Result(linkService.create(linkCreateRequest));
    }

    @GetMapping("/links")
    public Result getLinks(GetLinksRequest getLinksRequest) {
        //추후에 JWT를 도입하면 RequestDto는 없어도 될 것 같습니다.
        return new Result(
                new GetLinksResponse(linkRepository.findAllByMember(getLinksRequest.getUserId()))
        );
    }
}
