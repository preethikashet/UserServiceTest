package com.example.entity;

import jakarta.persistence.*;
import lombok.*;
import org.apache.logging.log4j.message.AsynchronouslyFormattable;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="preethika")
public class UserEntityPreethika {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column
    public String username;

}
