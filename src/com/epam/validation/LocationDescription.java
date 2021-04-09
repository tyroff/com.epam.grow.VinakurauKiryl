package com.epam.validation;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

/**
 * Additional description for precise location determination.
 *
 * @author Kiryl_Vinakurau
 */
public final class LocationDescription {
    private static final int MAX_NUMBER_IMAGES = 10;
    private String externalLandmarks;
    private String description;
    private File images[] = new File[MAX_NUMBER_IMAGES];

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

    public File[] getImages() {
        return images;
    }

    public void setImages(File[] images) {
        this.images = images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationDescription that = (LocationDescription) o;
        return Objects.equals(externalLandmarks, that.externalLandmarks) && Objects.equals(description,
                that.description) && Arrays.equals(images, that.images);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(externalLandmarks, description);
        result = 31 * result + Arrays.hashCode(images);
        return result;
    }

    @Override
    public String toString() {
        return "LocationDescription{" +
                "externalLandmarks='" + externalLandmarks + '\'' +
                ", description='" + description + '\'' +
                ", images=" + Arrays.toString(images) +
                '}';
    }
}
