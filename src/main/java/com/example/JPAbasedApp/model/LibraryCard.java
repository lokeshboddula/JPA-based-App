package com.example.JPAbasedApp.model;

import com.example.JPAbasedApp.enums.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private Department department;

    @CreationTimestamp
    private Date issueDate;

    @UpdateTimestamp
    private Date lastTransactionDate;

    @OneToOne
    @JoinColumn
    Student student;
}
