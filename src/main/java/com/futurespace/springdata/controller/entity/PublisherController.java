package com.futurespace.springdata.controller.entity;

import com.futurespace.springdata.controller.BaseController;
import com.futurespace.springdata.entity.Publisher;
import com.futurespace.springdata.service.entity.PublisherService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publishers")
public class PublisherController extends BaseController<Publisher, Long> {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        super(publisherService);
        this.publisherService = publisherService;
    }

    // Add any additional publisher-specific endpoints here if needed
}
