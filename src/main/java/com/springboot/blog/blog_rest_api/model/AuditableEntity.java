package com.springboot.blog.blog_rest_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@MappedSuperclass
public class AuditableEntity {
    @EqualsAndHashCode.Exclude
    public String createdBy;
    @EqualsAndHashCode.Exclude
    public String modifyBy;
    @EqualsAndHashCode.Exclude
    public Date createdAt;
    @EqualsAndHashCode.Exclude
    public Date modifyAt;
}
