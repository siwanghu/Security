package com.auditoryworks.repository;

import com.auditoryworks.domain.Asr;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsrRepository extends ElasticsearchRepository<Asr,String> {
    Asr queryById(String id);
    Page<Asr> queryByUser(String user, Pageable pageable);
    List<Asr> queryByUser(String user);
}