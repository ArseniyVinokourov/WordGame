package com.example.wordgame_spring.entities;

import com.github.rkpunjal.sqlsafe.SQLInjectionSafe;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "player")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(name = "nickname", nullable = false)
    private @SQLInjectionSafe String nickname;

    @Column(name = "score")
    private Integer score;

    public Player(String nickname, Integer score) {
        this.nickname = nickname;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format(" %s\t| %d points", nickname, score);
    }
}
