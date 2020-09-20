package com.thoughtworks.rslist.repository;

import com.thoughtworks.rslist.dto.RsEventDto;
import com.thoughtworks.rslist.dto.TradeDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface TradeRepository extends CrudRepository<TradeDto, Integer> {
    List<TradeDto> findAll();
    TradeDto findByRank(int rank);
    @Transactional
    void deleteAllByRsEventId(int rsEventId);
}
