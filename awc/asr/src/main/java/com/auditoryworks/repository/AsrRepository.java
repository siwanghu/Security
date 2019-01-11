package com.auditoryworks.repository;

import com.auditoryworks.domain.Asr;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsrRepository  extends JpaRepository<Asr, Long> {
    Asr findById(Long id);
    Page<Asr> findByUser(String user, Pageable pageable);
}