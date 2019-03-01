package com.shincom.graduation_project_backend_server.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.shincom.graduation_project_backend_server.controller.ApiController;
import lombok.Data;
import lombok.Getter;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data

public class FeedVO {
    private Integer feed_no;
    private String feed_contents;
    private boolean feed_like;
    private boolean feed_unlike;
    private String feed_created;
    private boolean edit;
    private String file;





}
