package com.example.gituserapp.Response;

import com.google.gson.annotations.SerializedName;

public class Items {
    @SerializedName("login")
    private String login;
    @SerializedName("avatar_url")
    private String avatarUrl;
    @SerializedName("bio")
    private String bio;
    @SerializedName("name")
    private String name;
    @SerializedName("public_repos")
    private String repository;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRepository() { return repository;}

    public void setRepository(String repository) {
        this.repository = repository;
    }
}