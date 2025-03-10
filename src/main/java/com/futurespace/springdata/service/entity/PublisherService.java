package com.futurespace.springdata.service.entity;

import com.futurespace.springdata.entity.Publisher;
import com.futurespace.springdata.repository.PublisherRepository;
import com.futurespace.springdata.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class PublisherService extends BaseService<Publisher, Long> {

    public PublisherService(PublisherRepository publisherRepository) {
        super(publisherRepository);
    }

    // Add anything only needed by the publisher (if needed)
}
