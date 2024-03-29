package io.voidengine.api.search;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

   private SearchRepository searchRepository;

    public SearchService(SearchRepository repo){
        searchRepository = repo;
    }

    public List<SearchResultDocument> search(String query){
        var ret = searchRepository.searchUrlTitleKeywordsDescriptionForWords(query,PageRequest.of(0, 10));
        System.out.println("response: " + ret);
        return ret;
    }
}
