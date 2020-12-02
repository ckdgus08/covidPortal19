package com.covidPotar19.repository;

import com.covidPotar19.domain.Bbs;
import com.covidPotar19.domain.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BbsRepository extends JpaRepository<Bbs, Long> {

    Page<Bbs> findByStatus(Status status, Pageable pageable);


}
