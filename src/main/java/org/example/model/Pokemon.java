package org.example.model;

public class Pokemon {
    //this class is used to hold the data that we pull from the pokemon api
    private String name;
    private String url;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //will return string format for results - give me a string representation?
    //who is the parent of this Object is the parent class of any class you do not use the extends
    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", id=" + id +
                '}';
    }
    //how am I going to take that api data and hold it in java?
    //if you want a detail about a pokemon you need that id
}
