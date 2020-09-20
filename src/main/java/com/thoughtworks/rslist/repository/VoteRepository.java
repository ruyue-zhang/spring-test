package com.thoughtworks.rslist.repository;

import com.thoughtworks.rslist.dto.VoteDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface VoteRepository extends PagingAndSortingRepository<VoteDto, Integer> {
    List<VoteDto> findAll();
    List<VoteDto> findAllByUserIdAndRsEventId(int userId, int rsEventId, Pageable pageable);
    void deleteAllByRsEventId(int rsEventId);
}
