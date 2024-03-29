package io.voidengine.api.search;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class SearchController {

    private SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search")
    public SearchResponse search(@RequestParam String query){
        System.out.println(query);
        List<SearchResultDocument> results = searchService.search(query);
        return SearchResponse.builder().results(results).resultCount(results.size()).build();
    }
}
