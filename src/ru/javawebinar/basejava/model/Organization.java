package ru.javawebinar.basejava.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import ru.javawebinar.basejava.util.DateUtil;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
@XmlAccessorType(XmlAccessType.FIELD)
public class Organization  implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Organization EMPTY = new Organization("", "", Position.EMPTY);


    private Link homePage;
    private List<Position> positions;

    public Organization() {
    }

    public Organization(String name, String url, Position... positions) {
        this(new Link(name, url), Arrays.asList(positions));
    }

    public Organization(Link homePage, List<Position> positions) {
        this.homePage = homePage;
        this.positions = positions;
    }

    public Link getHomePage() {
        return homePage;
    }

    public List<Position> getPositions() {
        return positions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (!homePage.equals(that.homePage)) return false;
        return positions.equals(that.positions);
    }

    @Override
    public int hashCode() {
        int result = homePage.hashCode();
        result = 31 * result + positions.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "homePage=" + homePage +
                ", positions=" + positions +
                '}';
    }
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Position  implements Serializable {
        public static final Position EMPTY =
                new Position(new Period(DateUtil.NOW, DateUtil.NOW), "","");
        private Period period;
        private String title;
        private String description;

        public Position() {
        }

        public Position(Period period, String title, String description) {
            Objects.requireNonNull(title, "title must not be null");
            this.period = period;
            this.title = title;
            this.description = description == null ? "" : description;
        }

        public Period getPeriod() {
            return period;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Position position = (Position) o;

            if (!period.equals(position.period)) return false;
            if (!title.equals(position.title)) return false;
            return Objects.equals(description, position.description);
        }

        @Override
        public int hashCode() {
            int result = period.hashCode();
            result = 31 * result + title.hashCode();
            result = 31 * result + (description != null ? description.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "period=" + period +
                    ", title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }
    }
}
