package com.Coherent.CDK.entity;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class Datas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Short id;

    @Column(name = "name")
    @Size(min = 3, max = 20)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String data;

    @Column(name = "is_active", columnDefinition = "Byte default 1")
    private Byte isActive;

    @Column(name = "delete_flag", columnDefinition = "Byte default 0")
    private Byte deleteFlag;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_at")
    @UpdateTimestamp
    private LocalDateTime modifiedAt;

    @Column(name = "modified_by")
    private String modifiedBy;

    /*@OneToOne
    @JoinColumn(name = "files_id_fk")
    private Files filesId;*/

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id_fk")
    private Projects projectsId;
}
