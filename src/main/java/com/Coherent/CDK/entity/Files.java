package com.Coherent.CDK.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@SQLDelete(sql = "UPDATE files SET delete_flag=1 WHERE file_id= ? ")
@Table(name = "files")
public class Files {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private  Short id;

    @Column(name = "original_name")
    @Size(min = 3, max = 100)
    private String originalName;

    @Column(name = "generated_name")
    @Size(min = 3, max = 50)
    private String generatedName;

    @Column(name = "path")
    @Size(min = 3, max = 100)
    private String path;

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

}
