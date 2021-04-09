package com.epam.validation;

import java.util.Objects;

/**
 * Additional description for precise location determination.
 *
 * @author Kiryl_Vinakurau
 */
public final class LocationDescription {
    private String externalLandmarks;
    private String description;

    public LocationDescription(String description) {
        this.description = description;
    }

    public LocationDescription(String externalLandmarks, String description) {
        this.externalLandmarks = externalLandmarks;
        this.description = description;
    }

    public String getExternalLandmarks() {
        return externalLandmarks;
    }

    public void setExternalLandmarks(String externalLandmarks) {
        this.externalLandmarks = externalLandmarks;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationDescription that = (LocationDescription) o;
        return Objects.equals(externalLandmarks, that.externalLandmarks) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(externalLandmarks, description);
    }

    @Override
    public String toString() {
        return "LocationDescription{" +
                "externalLandmarks='" + externalLandmarks + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
