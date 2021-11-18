package com.Coherent.CDK.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@SQLDelete(sql = "UPDATE files SET delete_flag=1 WHERE id= ? ")
@Table(name = "files")
public class Files {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Short id;

    @Column(name = "original_fileName")
    @Size(min = 3, max = 100)
    private String originalFileName;

    @Column(name = "generated_fileName")
    @Size(min = 3, max = 50)
    private String generatedFileName;

    @Column(name = "path")
    @Size(min = 3, max = 100)
    private String path;

    @Lob
    private byte[] data;

    @Column(name = "is_active", columnDefinition = "TINYINT default 1")
    private byte isActive;

    @Column(name = "delete_flag", columnDefinition = "TINYINT default 0")
    private byte deleteFlag;

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