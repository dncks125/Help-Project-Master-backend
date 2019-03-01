package com.shincom.graduation_project_backend_server.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class FeedReVO {
    private int feed_re_no;
    private String comment;
    private int feed_no;
    private String created;
    private int parents_id;
    private boolean edit;
    private boolean reply;


}
