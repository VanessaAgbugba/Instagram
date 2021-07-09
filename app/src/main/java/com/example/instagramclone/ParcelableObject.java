package com.example.instagramclone;

import org.parceler.Parcel;

@Parcel
public class ParcelableObject {

    Post post;

    public ParcelableObject(){}

    public void setPost(Post post){
        this.post = post;
    }
    public Post getPost(){
        return post;
    }
}
