package com.springboot.blog.blog_rest_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class AuditableEntity {
    public String createdBy;
    public String modifyBy;
    public Date createdAt;
    public Date modifyAt;
}
