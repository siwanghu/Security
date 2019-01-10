package com.auditoryworks.domain;

import com.auditoryworks.domain.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Device extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String deviceId;

    private String user;
}
