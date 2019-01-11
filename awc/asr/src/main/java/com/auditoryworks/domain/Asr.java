package com.auditoryworks.domain;
import com.auditoryworks.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Asr extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private Long time;

    private Long  important;

    private Date deadline;

    private String sessionId;

    private String user;
}