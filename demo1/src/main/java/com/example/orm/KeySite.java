package com.example.orm;

import lombok.*;

import java.util.Objects;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class KeySite {
    private String name;
    private Integer pid;

/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeySite keySite = (KeySite) o;
        return name.equals(keySite.name) && pid.equals(keySite.pid);
    }

    @Override
    public int hashCode() {
        return 1;
    }*/
}
