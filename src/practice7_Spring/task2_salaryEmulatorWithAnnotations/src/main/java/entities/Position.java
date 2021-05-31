package entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * This class contains the position held in the organization.
 *
 * @author Kiryl_Vinakurau
 */
@Component
@Scope("prototype")
public class Position {

    private String name;

    public Position(String namePosition) {
        this.name = namePosition;
    }

    public Position() {}

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        if (!super.equals(o)) return false;
        Position position = (Position) o;
        return Objects.equals(name, position.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    @Override
    public String toString() {
        return "Position{" +
                "name='" + name + '\'' +
                '}';
    }
}
