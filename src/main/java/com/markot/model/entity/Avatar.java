package com.markot.model.entity;

import java.util.Objects;

public class Avatar {

    private Integer id;

    private String fileName;

    private Float fileSizeInMb;

    public Avatar(Integer id, String fileName, Float fileSizeInMb) {
        this.id = id;
        this.fileName = fileName;
        this.fileSizeInMb = fileSizeInMb;
    }

    public Avatar(String fileName, Float fileSizeInMb) {
        this.fileName = fileName;
        this.fileSizeInMb = fileSizeInMb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avatar avatar = (Avatar) o;
        return id.equals(avatar.id)
                && fileName.equals(avatar.fileName)
                && fileSizeInMb.equals(avatar.fileSizeInMb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fileName, fileSizeInMb);
    }

    @Override
    public String toString() {
        return "\nAvatar{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", fileSizeInMb=" + fileSizeInMb +
                '}';
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Float getFileSizeInMb() {
        return fileSizeInMb;
    }

    public void setFileSizeInMb(Float fileSizeInMb) {
        this.fileSizeInMb = fileSizeInMb;
    }
}
