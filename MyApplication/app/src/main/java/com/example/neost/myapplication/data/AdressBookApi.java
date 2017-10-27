package com.example.neost.myapplication.data;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by neost on 27/10/2017.
 */

public interface AdressBookApi {

    @GET("/groups")
    Call<List<Group>> getGroupList();

    @GET("/groups/(group)")
    Call<Group> getGroup(@Path("group") int groupId);
}
