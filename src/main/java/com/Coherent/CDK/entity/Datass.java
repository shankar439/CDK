package com.Coherent.CDK.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@Entity
@Table(name = "Datass")
public class Datass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Short id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "details",columnDefinition = "TEXT")
    private String Details;

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

    @NotNull
    @OneToOne
    @JoinColumn(name = "files_id_fk")
    private Files filesId;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id_fk")
    private Projects projectsId;
}
